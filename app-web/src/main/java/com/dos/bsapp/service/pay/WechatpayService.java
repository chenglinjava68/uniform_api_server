package com.dos.bsapp.service.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.dos.bsapp.controller.UPayController;
import com.dos.bsapp.dao.AlipayDao;
import com.dos.bsapp.dao.AppPayDao;
import com.dos.bsapp.dao.VUnitDao;
import com.dos.bsapp.model.AlipayCallbackLog;
import com.dos.bsapp.model.AppPay;
import com.dos.bsapp.model.VUnit;
import com.dos.bsapp.service.pay.config.WebchatpayConfig;
import com.webchat.CreatePayLinkData;
import com.webchat.NativeNotifyResData;
import com.webchat.NativeNotifyReturnData;
import com.webchat.PayOverResData;
import com.webchat.UnifiedorderReqData;
import com.webchat.UnifiedorderResData;
import com.webchat.WechatUtil;

import java.util.Collections;
import java.util.Comparator;

@Service("WechatpayService")
public class WechatpayService extends PayIf {
	private Logger logger = LoggerFactory.getLogger(WechatpayService.class);
	
	@Resource
	private VUnitDao vunitDao;
	
	@Resource
	private AppPayDao appPayDao;
	
	//@Resource
	//private AlipayDao alipayDao;
	
	private String portName = "Wechatpay";
	
	@Override
	public boolean canProcessPort(String portName) {
		//return false;
		System.out.println("local PortName :"+this.portName+" compare with input portName:"+portName);
		return this.portName.toLowerCase().equals(portName.toLowerCase());
	}



	protected WebchatpayConfig getWebchatpayConfig(String setting){
			   logger.error("getWebchatpayConfig setting:" + setting);
		return (WebchatpayConfig)util.JsonUtil.parseString(setting, WebchatpayConfig.class);
	}


	public static class createPayLinkParam extends util.PostParam
    	{
    		private String orderName;
    		private String totalPrice;
    		private String showUrl;
    		private String overTime;

    		public boolean checkParam() throws Exception {
    			if (orderName == null
    					|| totalPrice == null || showUrl == null || overTime == null) {
    				this.setMessage("部分参数为空");
    				return false;
    			}
    			return true;
    		}

    		public String getOrderName() {
    			return orderName;
    		}

    		public void setOrderName(String orderName) {
    			this.orderName = orderName;
    		}

    		public String getTotalPrice() {
    			return totalPrice;
    		}

    		public void setTotalPrice(String totalPrice) {
    			this.totalPrice = totalPrice;
    		}

    		public String getShowUrl() {
    			return showUrl;
    		}

    		public void setShowUrl(String showUrl) {
    			this.showUrl = showUrl;
    		}

    		public String getOverTime() {
    			return overTime;
    		}

    		public void setOverTime(String overTime) {
    			this.overTime = overTime;
    		}
    	};

	@Override
	public String createPayLink(VUnit unit,AppPay ap,String orderSeriesNumber,String data) throws Exception {
		if(!unit.isUsable())
		{
			throw new Exception("指定的App或者服务被锁定，无法处理支付。");
		}
		if(ap.getIsPaid() == null || ap.getIsPaid().equals(1))
		{
			throw new Exception("您的订单已经被支付，请在系统中查看订单状态");
		}
		String sLink = ap.getWechatPayLink();
		logger.debug("createPayLink, with orderSeriesNumber:"+orderSeriesNumber+" with data:"+data);
		if(sLink == null || sLink.isEmpty())
		{
    		createPayLinkParam param = (createPayLinkParam) util.JsonUtil.parseString(data, createPayLinkParam.class);
            if (param == null || !param.checkParam())
            		throw new Exception("参数有问题");

    		WebchatpayConfig config = getWebchatpayConfig(unit.getSetting());
    		String productId = orderSeriesNumber;
    		sLink =  CreatePayLinkData.getPayLink(config.getAppid(),config.getMchId(), ap.getTotalSeriesNumber(), config.getKey());
			ap.setWechatPayLink(sLink, param.getOrderName(),param.getTotalPrice(),param.getShowUrl(),param.getOverTime());
			appPayDao.updateWechatPayLink(ap);
    		return sLink;
		}
		else{
			logger.debug("pay Link is exist with:"+sLink);
			return sLink;
		}

	}


	public void notify(@RequestBody String xmlData, HttpServletRequest request, HttpServletResponse response) throws Exception{
		

		NativeNotifyResData resData = (NativeNotifyResData) WechatUtil.getObjectFromXML(xmlData, NativeNotifyResData.class);
        if (resData == null ) {
            logger.error("微信服务器传递过来的数据错误。");
            return;
        }
        String out_trade_no = resData.getProduct_id();
        logger.info("get out_trade_no:"+out_trade_no);
        AppPay ap = appPayDao.getByTotalSeriesNumber(resData.getProduct_id());
		if(ap==null)
		{
			//throw new Exception("out_trade_no:？:" + out_trade_no + " , 没有对应的订单信息");
			return;
		}
		if(ap.getIsPaid() == null || ap.getIsPaid().equals(1))
		{
			//throw new Exception("您的订单已经被支付，请在系统中查看订单状态");
			return;
		}
		VUnit vunit = vunitDao.getByPortTitleAndAppId(portName, ap.getAppId().intValue());
		if(vunit==null){
			//throw new Exception("out_trade_no:？:" + out_trade_no + " , 没有对应的服务注册信息");
			return;
		}
		if(!vunit.isUsable())
		{
			/*
			retData.sysError("指定的App或者服务被锁定，无法处理支付。");
			retData.MakeSign(config.getKey());
			response.getWriter().write(retData.toXml());
			*/
			return;
		}
		WebchatpayConfig config = getWebchatpayConfig(vunit.getSetting());
		if(!resData.verifySign(config.getKey())){
			logger.error("resData.verifySign failed.微信发过来的数据错误");
			return;
		}
		NativeNotifyReturnData retData = NativeNotifyReturnData.init(config.getAppid(), config.getMchId());

		String prepareId = ap.getUsableWechatPrepareId();
		if(prepareId == null || prepareId.isEmpty())
		{
				//统一下单
                UnifiedorderReqData eoReq = new UnifiedorderReqData();
                eoReq.setAppid(resData.getAppid());
                eoReq.setMch_id(resData.getMch_id());
                eoReq.setNonce_str(util.Random.generateWithCharNumber(12));
                eoReq.setTime_start(((new Date()).getTime() / 1000)+"");
                if(ap.getOrderName()==null || ap.getOrderName().isEmpty())
                	eoReq.setBody("四季旅行网-签证产品支付");
                else
                	eoReq.setBody("四季旅行网-"+ap.getOrderName());
                eoReq.setDetail("");
                eoReq.setAttach(out_trade_no);
                int sRandomLen = 32 - out_trade_no.length() -1;
                eoReq.setOut_trade_no(out_trade_no+util.Random.generateWithCharNumber(sRandomLen));
                if(config.isDebug())
                	eoReq.setTotal_fee(1);
                else
                	eoReq.setTotal_fee(ap.getTotalPrice());
                
                eoReq.setSpbill_create_ip(config.getLocalIp());  //得到本地的IP
                eoReq.setNotify_url(config.getNotifyUrl());
                eoReq.setProduct_id(out_trade_no);
                eoReq.setOpenid(resData.getOpenid());
                eoReq.MakeSign(config.getKey());
        		String toXml = eoReq.toXml();
        		logger.info("开始统一下单 with toXml:"+toXml);
        		String inputLine =  "";
        		try{
        			logger.info("开始统一下单");
        			URL postUrl = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
            		HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
            		connection.setDoOutput(true);
            		connection.setDoInput(true);
            		connection.setRequestMethod("POST");
            		connection.setUseCaches(false);
            		connection.setInstanceFollowRedirects(true);
            		connection.setRequestProperty("Content-Type", "application/json");
            		connection.connect();

            		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            		out.write(toXml);
            		out.flush();
            		out.close();

            		BufferedReader in = new BufferedReader(new InputStreamReader(connection
                            .getInputStream()));
            		String temp = in.readLine();
            		while(temp != null){
            			inputLine = inputLine + temp;
            			temp = in.readLine();
            		}
            		in.close();
        		}
        		catch(Exception e)
        		{
        			logger.info("统一下单错误："+e.getMessage());
        			inputLine = "";
        			retData.sysError("统一下单通讯错误");
        			retData.MakeSign(config.getKey());
        			response.getWriter().write(retData.toXml());
        			return;
        		}

        		logger.info("UnifiedorderResData resData:"+inputLine);
        		UnifiedorderResData eoRes = (UnifiedorderResData) WechatUtil.getObjectFromXML(inputLine, UnifiedorderResData.class);
                if (eoRes == null ) {
        			logger.error("支付订单查询请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
        			retData.sysError("支付订单查询请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
        			retData.MakeSign(config.getKey());
        			response.getWriter().write(retData.toXml());
                }

        		if(!eoRes.verifySign(config.getKey())){
        			retData.sysError("统一下单通讯错误");
        			retData.MakeSign(config.getKey());
        			response.getWriter().write(retData.toXml());
        			return;
        		}
        		if(!eoRes.getReturn_code().equals("SUCCESS")){
        			retData.sysError("统一下单通讯错误2");
        			retData.MakeSign(config.getKey());
        			response.getWriter().write(retData.toXml());
        			return;
        		}
        		if(!eoRes.getResult_code().equals("SUCCESS")){
        			retData.sysError("统一下单业务错误");
        			retData.MakeSign(config.getKey());
        			response.getWriter().write(retData.toXml());

        			String errCode = eoRes.getErr_code();
        			String errCodeDes = eoRes.getErr_code_des();
        			return;
        		}
        		retData.setPrepay_id(eoRes.getPrepay_id());
        		ap.setUsableWechatPrepareId(eoRes.getPrepay_id());
        		appPayDao.updateWechatPrepareId(ap);
        		appPayDao.addNewPrepareIdRecord(ap.getWechatPrepareId(),eoReq.getAppid(),eoReq.getMch_id(),eoReq.getOut_trade_no(),eoReq.getAttach(),
        				eoReq.getTotal_fee(),eoReq.getBody());
		}
		else
		{
			retData.setPrepay_id(prepareId);
		}

		retData.MakeSign(config.getKey());
		response.getWriter().write(retData.toXml());

		return;
	}

	public void buyOverNotify(@RequestBody String xmlData, HttpServletRequest request, HttpServletResponse response) {
		PayOverResData resData = (PayOverResData) WechatUtil.getObjectFromXML(xmlData, PayOverResData.class);
        if (resData == null ) {
            logger.error("支付订单查询请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
            return;
        }
        String out_trade_no = resData.getOut_trade_no();
        String trade_no = resData.getAttach();
        logger.info("buyOverNotify trade_no:"+trade_no);
        AppPay ap = appPayDao.getByTotalSeriesNumber(trade_no);
		if(ap==null)
		{
			//throw new Exception("trade_no:？:" + trade_no + " , 没有对应的订单信息");
			return;
		}
		VUnit vunit = vunitDao.getByPortTitleAndAppId(portName, ap.getAppId().intValue());
		if(vunit==null){
			//throw new Exception("trade_no:？:" + trade_no + " , 没有对应的服务注册信息");
			return;
		}
		WebchatpayConfig config = getWebchatpayConfig(vunit.getSetting());
		if(!resData.verifySign(config.getKey())){
			logger.error("resData.verifySign failed.微信发过来的数据错误");
			return;
		}
		if(!resData.getReturn_code().equals("SUCCESS")){
			//retData.sysError("统一下单通讯错误2");
			//retData.MakeSign(config.getKey());
			//.getWriter().write(retData.toXml());
			return;
		}
		if(!resData.getResult_code().equals("SUCCESS")){
			//retData.sysError("统一下单业务错误");
			//retData.MakeSign(config.getKey());
			//response.getWriter().write(retData.toXml());
			
			//String errCode = eoRes.getErr_code();
			//String errCodeDes = eoRes.getErr_code_des();
			return;
		}
		if(ap.getIsPaid().equals(1)){
			if(!ap.getPaidPort().equals("Wechatpay")){
				appPayDao.addNewNeedRefund("Wechatpay",xmlData);
				//log.setErrorException("App 已经被其他方式支付，不能重复支付:"+ap.getPaidPort() );
				//alipayDao.addCallbackLog(log);
				//throw new Exception("App 已经被其他方式支付，不能重复支付");
			}
		}
		else{
			ap.setPaid(1,"Wechatpay",new Date(),JSONObject.toJSONString(xmlData));
			appPayDao.setPaid(ap);
			appPayDao.updatePrepareIdPaid(out_trade_no,resData.getTransaction_id(),resData.getTotal_fee(),resData.getOpenid());
		}
		
		String real_out_trade_no = ap.getOrderSeriesNumber();
		String back_sign = util.MD5.getMD5ofString(vunit.getSeriesNumber() + real_out_trade_no + vunit.getAppSeriesNumber());
		String sUrl = config.getRealNotifyUrl() +"?back_sign=" + back_sign;
		sUrl += ("&"+"result_code"+"="+resData.getResult_code());
		sUrl += ("&"+"openid"+"="+resData.getOpenid());
		sUrl += ("&"+"out_trade_no"+"="+real_out_trade_no);
		sUrl += ("&"+"bank_type"+"="+resData.getBank_type());
		sUrl += ("&"+"total_fee"+"="+resData.getTotal_fee());
		sUrl += ("&"+"trade_type"+"="+resData.getTrade_type());
		sUrl += ("&"+"transaction_id"+"="+resData.getTransaction_id());
		sUrl += ("&"+"cash_fee"+"="+resData.getCash_fee());
		sUrl += ("&"+"cash_fee_type"+"="+resData.getCash_fee_type());
		sUrl += ("&"+"coupon_fee"+"="+resData.getCoupon_fee());
		
		try 
		{
			logger.error("Wechatpay.notifyCall url:"+sUrl);
            URL url = new URL(sUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            String inputLine = in.readLine().toString();
            logger.error("url inputLine:"+inputLine);
            ap.setCalledBack(1);
            appPayDao.updateCalledBack(ap);
        } catch (Exception e) {
        	//需要重新发送
        	appPayDao.addNewNeedReCallbackRecord(sUrl);
        }

		String ResToWX = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		try {
			response.getWriter().write(ResToWX);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ;
	}

}
