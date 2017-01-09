package com.dos.bsapp.service.pay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

import com.alibaba.fastjson.JSONObject;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.dos.bsapp.dao.AlipayDao;
import com.dos.bsapp.dao.AppPayDao;
import com.dos.bsapp.dao.VUnitDao;
import com.dos.bsapp.model.AlipayCallbackLog;
import com.dos.bsapp.model.AppPay;
import com.dos.bsapp.model.VUnit;

import util.JsonUtil;

@Service("AlipayService")
public class AlipayService extends PayIf {
	private Logger logger = LoggerFactory.getLogger(AlipayService.class);
	
	@Resource
	private VUnitDao vunitDao;
	
	@Resource
	private AppPayDao appPayDao;
	
	@Resource
	private AlipayDao alipayDao;
	
	@Override
	public boolean canProcessPort(String portName) {
		return "alipay".equals(portName.toLowerCase());
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

	protected AlipayConfig getAlipayConfig(String setting){
			   logger.error("getAlipayConfig setting:" + setting);
			   return (AlipayConfig)util.JsonUtil.parseString(setting, AlipayConfig.class);
	}
	
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

		/*
		AlipayConfig alipayConfig = AlipayConfig.newConfig("2088121608978301", "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALSXEAG3ddNy6SDtenzYl7P6hw7RgaH7S65fzBDCDE91uPsg1ZZ7IoulCJHPJ", 
				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB", 
				"/root/alipaydir/", "utf-8", "RSA", "http://127.0.0.1:8080/qqvisa/api/alipay/notify_url", 
				"http://127.0.0.1:8080/qqvisa/api/alipay/return_url","isRealMode":true);*/
		AlipayConfig alipayConfig = getAlipayConfig(unit.getSetting());
		System.out.println("Alipay setting:"+unit.getSetting());
		System.out.println("Alipayconfig:"+util.JsonUtil.stringify(alipayConfig));
		
		createPayLinkParam param = (createPayLinkParam) util.JsonUtil.parseString(data, createPayLinkParam.class);
		if (param == null || !param.checkParam())
			throw new Exception("参数有问题");

		// 支付类型,必填，不能修改
		String payment_type = "1";
		System.out.println("alipayConfig.partner:" + alipayConfig.getPartner());
		System.out.println("alipayConfig.seller_id:" + alipayConfig.getSellerId());

		// 以下参数是淘宝提供的参数，提交到淘宝支付网关的，至于用户的
		// 个人信息（收获地址、手机号、姓名等）、商品信息（单价、购买个数）需要自己维护
		// 把请求参数打包成数组
		System.out.println("Alipay notify_url:"+alipayConfig.getNotifyUrl());
		System.out.println("Alipay return_url:"+alipayConfig.getReturnUrl());
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
		sParaTemp.put("partner", alipayConfig.getPartner());
		sParaTemp.put("seller_id", alipayConfig.getSellerId());
		sParaTemp.put("_input_charset", alipayConfig.getInputCharset());
		sParaTemp.put("payment_type", payment_type);// 支付类型
		sParaTemp.put("notify_url", alipayConfig.getNotifyUrl());// 服务器异步通知页面路径
		sParaTemp.put("return_url", alipayConfig.getReturnUrl());// 页面跳转同步通知页面路径
		//AppPay中的totalSeriesNumber是appSeriesNumber+OrderSeriesNumber的值
		sParaTemp.put("out_trade_no", ap.getTotalSeriesNumber());// 商户订单号

		String codeOrderName = "";
		StringBuffer sb = new StringBuffer();
		sb.append(param.getOrderName());
		String xmString = "";
		try {
			xmString = new String(sb.toString().getBytes("UTF-8"));
			codeOrderName = URLEncoder.encode(xmString, "UTF-8");
		} catch (Exception e) {
			codeOrderName = "";
		}
		System.out.print(param.getOrderName());
		sParaTemp.put("subject", param.getOrderName());// 订单名称
		if(alipayConfig.isRealMode())
			sParaTemp.put("total_fee", param.getTotalPrice());// 付款金额
		else
			sParaTemp.put("total_fee", "0.01");// 测试状态的时候使用0.01做交易
		sParaTemp.put("show_url", param.getShowUrl());// TODO 商品展示地址
		sParaTemp.put("body", ""); // payInfo.getOrderDesc());//订单描述
		sParaTemp.put("it_b_pay", param.getOverTime());// 超时时间
		sParaTemp.put("extern_token", ""); // 钱包token 问了技服，该参数已经弃用了

		try 
		{
			String payLink = AlipaySubmit.buildPayLink(sParaTemp,alipayConfig);
			System.out.println("service pay:" + payLink);
			return payLink;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	protected Map<String, String> verifyAlipayParams(HttpServletRequest request,AlipayCallbackLog log) throws Exception{
		String out_trade_no = "";
		String trade_no = "";
		String trade_status = "";
		String buyer_email = "";
		String buyer_id = "";
		Map<String, String> retParam = new HashMap<String, String>();
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		System.out.println("-----------------notify url----start");
		StringBuffer sb = new StringBuffer();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
			sb.append(name+":"+valueStr);
			
			if("out_trade_no".equals(name)){out_trade_no = valueStr;}
			if("trade_no".equals(name)){trade_no = valueStr;}
			if("trade_status".equals(name)){trade_status = valueStr;}
			if("buyer_email".equals(name)){buyer_email = valueStr;}
			if("buyer_id".equals(name)){buyer_id = valueStr;}
		}
		logger.debug("verifyAlipayParams input param is :" + sb.toString());
		log.setInputParam(sb.toString());
		System.out.println("param string: "+ sb.toString());
		
		if(out_trade_no == null || out_trade_no.isEmpty()){
			log.setErrorException("out_trade_no 未发现，非法的返回信息？:");
			alipayDao.addCallbackLog(log);
			throw new Exception("out_trade_no 未发现，非法的返回信息？:" + sb.toString());
		}
		log.setOutTradeNo(out_trade_no);
		
		//out_trade_no -> AppPay -> app + alipay -> vunit
		AppPay ap = appPayDao.getByTotalSeriesNumber(out_trade_no);
		if(ap==null){
			log.setErrorException("out_trade_no:？:" + out_trade_no + " , 没有对应的订单信息");
			alipayDao.addCallbackLog(log);
			throw new Exception("out_trade_no:？:" + out_trade_no + " , 没有对应的订单信息");
		}
		System.out.println("appid:"+ap.getAppId());
		log.setAppId(ap.getAppId());
		VUnit vunit = vunitDao.getByPortTitleAndAppId("Alipay", ap.getAppId().intValue());
		if(vunit==null){
			log.setErrorException("out_trade_no:？:" + out_trade_no + " , 没有对应的服务注册信息");
			alipayDao.addCallbackLog(log);
			throw new Exception("out_trade_no:？:" + out_trade_no + " , 没有对应的服务注册信息");
		}
		log.setAppSeriesNumber(vunit.getAppSeriesNumber());
		log.setUnitId(vunit.getId());
		log.setUnitSeriesNumber(vunit.getSeriesNumber());
		
		
		AlipayConfig alipayConfig = getAlipayConfig(vunit.getSetting());
		logger.error("alipayConfig data:"+util.JsonUtil.stringify(alipayConfig));
		boolean bVerify = AlipayNotify.verify(params, alipayConfig);
		if(!bVerify)
		{
			log.setErrorException("参数返回错误,不是Alipay返回的？");
			alipayDao.addCallbackLog(log);
			throw new Exception("参数返回错误,不是Alipay返回的？");
		}
		
		
		String real_out_trade_no = ap.getOrderSeriesNumber();
		retParam.put("out_trade_no", real_out_trade_no);
		retParam.put("trade_no", trade_no);
		retParam.put("trade_status", trade_status);
		retParam.put("buyer_email", buyer_email);
		retParam.put("buyer_id", buyer_id);
		String back_sign = util.MD5.getMD5ofString(vunit.getSeriesNumber() + real_out_trade_no + vunit.getAppSeriesNumber());
		retParam.put("back_sign", back_sign);
		retParam.put("return_url", alipayConfig.getRealReturnUrl());
		retParam.put("notify_url", alipayConfig.getRealNotifyUrl());
		
		log.setTradeNo(trade_no);
		log.setTradeStatus(trade_status);
		log.setBuyerEmail(buyer_email);
		log.setBuyerId(buyer_id);
		log.setBackSign(back_sign);
		log.setReturnUrl(alipayConfig.getRealReturnUrl());
		log.setNotifyUrl(alipayConfig.getRealNotifyUrl());
		
		if(ap.getIsPaid().equals(1)){
			if(!ap.getPaidPort().equals("Alipay")){
				appPayDao.addNewNeedRefund("Alipay",sb.toString());
				log.setErrorException("App 已经被其他方式支付，不能重复支付:"+ap.getPaidPort() );
				alipayDao.addCallbackLog(log);
				throw new Exception("App 已经被其他方式支付，不能重复支付");
			}
		}
		else{
			ap.setPaid(1,"Alipay",new Date(),JSONObject.toJSONString(params));
			appPayDao.setPaid(ap);
		}
		
		return retParam;
	}
	public String returnCall(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> ret = null;
		AlipayCallbackLog log = new AlipayCallbackLog();
		log.setFromMethod("returnCall");
		try
		{
			ret = verifyAlipayParams(request,log);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return "";
		}
		try 
		{
			String out_trade_no = ret.get("out_trade_no");
			String trade_no = ret.get("trade_no");
			String trade_status = ret.get("trade_status");
			String buyer_email = ret.get("buyer_email");
			String buyer_id = ret.get("buyer_id");
			String back_sign = ret.get("back_sign");
			String return_url = ret.get("return_url");
			//String notify_url = ret.get("notify_url");
			
			String sUrl = return_url +"?back_sign=" + back_sign;
			sUrl += ("&"+"buyer_id"+"="+buyer_id);
			sUrl += ("&"+"buyer_email"+"="+buyer_email);
			sUrl += ("&"+"trade_status"+"="+trade_status);
			sUrl += ("&"+"trade_no"+"="+trade_no);
			sUrl += ("&"+"out_trade_no"+"="+out_trade_no);
			logger.error("AlipayService.notifyCall url:"+sUrl);
            URL url = new URL(sUrl);
            log.setCallClientUrl(sUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            String inputLine = in.readLine().toString();
            logger.error("url inputLine:"+inputLine);
            //log.setCallClientReturn(inputLine);
            alipayDao.addCallbackLog(log);
            return  inputLine;
        } catch (Exception e) {
            e.printStackTrace();
            String inputLine ="";
            log.setCallClientReturn(e.getMessage());
            alipayDao.addCallbackLog(log);
            return inputLine;
        }
	}

	public String notifyCall(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> ret = null;
		AlipayCallbackLog log = new AlipayCallbackLog();
		log.setFromMethod("notifyCall");
		try
		{
			ret = verifyAlipayParams(request,log);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return "fail";
		}
		try {
			String out_trade_no = ret.get("out_trade_no");
			String trade_no = ret.get("trade_no");
			String trade_status = ret.get("trade_status");
			String buyer_email = ret.get("buyer_email");
			String buyer_id = ret.get("buyer_id");
			String back_sign = ret.get("back_sign");
			//String return_url = ret.get("return_url");
			String notify_url = ret.get("notify_url");
			
			String sUrl = notify_url +"?back_sign=" + back_sign;
			sUrl += ("&"+"buyer_id"+"="+buyer_id);
			sUrl += ("&"+"buyer_email"+"="+buyer_email);
			sUrl += ("&"+"trade_status"+"="+trade_status);
			sUrl += ("&"+"trade_no"+"="+trade_no);
			sUrl += ("&"+"out_trade_no"+"="+out_trade_no);
			logger.error("AlipayService.notifyCall url:"+sUrl);
            URL url = new URL(sUrl);

            log.setCallClientUrl(sUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            String inputLine = in.readLine().toString();
            logger.error("url inputLine:"+inputLine);
            log.setCallClientReturn(inputLine);
            alipayDao.addCallbackLog(log);
            return inputLine;
        } catch (Exception e) {
            e.printStackTrace();
            String inputLine ="fail";
            log.setCallClientReturn("fail" + e.getMessage());
            alipayDao.addCallbackLog(log);
            return inputLine;
        }
	}

}
