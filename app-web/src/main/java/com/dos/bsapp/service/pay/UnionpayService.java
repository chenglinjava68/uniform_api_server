package com.dos.bsapp.service.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.config.AlipayConfig;
import com.dos.bsapp.dao.AppPayDao;
import com.dos.bsapp.dao.VUnitDao;
import com.dos.bsapp.model.AlipayCallbackLog;
import com.dos.bsapp.model.AppPay;
import com.dos.bsapp.model.VUnit;
import com.unionpay.acp.sdk.*;

@Service("UnionpayService")
public class UnionpayService extends PayIf {
	private Logger logger = LoggerFactory.getLogger(UnionpayService.class);

	@Resource
	private VUnitDao vunitDao;

	@Resource
	private AppPayDao appPayDao;


	@Override
	public boolean canProcessPort(String portName) {
		return "unionpay".equals(portName.toLowerCase());
	}

	public static class createPayLinkParam extends util.PostParam {
		private String orderName;
		private String totalPrice;
		private String showUrl;
		private String overTime;

		@Override
		public boolean checkParam() throws Exception {
			if (orderName == null || totalPrice == null || showUrl == null || overTime == null) {
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

	protected UnionpayConfig getUnionpayConfig(String setting) {
		logger.error("getUnionpayConfig setting:" + setting);
		return (UnionpayConfig) util.JsonUtil.parseString(setting, UnionpayConfig.class);
	}

	@Override
	public String createPayLink(VUnit unit, AppPay ap, String orderSeriesNumber, String data) throws Exception {
		logger.debug("UnionpayService::createPayLink is called.");
		if (!unit.isUsable()) {
			throw new Exception("指定的App或者服务被锁定，无法处理支付。");
		}
		if (ap.getIsPaid() == null || ap.getIsPaid().equals(1)) {
			throw new Exception("您的订单已经被支付，请在系统中查看订单状态");
		}

		UnionpayConfig config = getUnionpayConfig(unit.getSetting());
		System.out.println("Unionpay setting:" + unit.getSetting());
		logger.debug("UnionpayConfig:" + util.JsonUtil.stringify(config));
		

		createPayLinkParam param = (createPayLinkParam) util.JsonUtil.parseString(data, createPayLinkParam.class);
		if (param == null || !param.checkParam())
			throw new Exception("参数有问题");

		/////////////////////////////// Union Pay
		Map<String, String> requestData = new HashMap<String, String>();

		/*** 银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改 ***/
		requestData.put("version", config.getVersion()); // 版本号，全渠道默认值
		requestData.put("encoding", config.getCharset()); // 字符集编码，可以使用UTF-8,GBK两种方式
		requestData.put("signMethod", "01"); // 签名方法，只支持 01：RSA方式证书加密
		requestData.put("txnType", "01"); // 交易类型 ，01：消费
		requestData.put("txnSubType", "01"); // 交易子类型， 01：自助消费
		requestData.put("bizType", "000201"); // 业务类型，B2C网关支付，手机wap支付
		requestData.put("channelType", "07"); // 渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板
												// 08：手机

		/*** 商户接入参数 ***/
		requestData.put("merId", config.getMerId()); // 商户号码，请改成自己申请的正式商户号或者open上注册得来的777测试商户号
		requestData.put("accessType", "0"); // 接入类型，0：直连商户
		requestData.put("orderId", ap.getTotalSeriesNumber()); // 商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
		requestData.put("txnTime", util.DateUtil.DateToString(new Date(), "yyyyMMddhhmmss")); // 订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
		requestData.put("currencyCode", "156"); // 交易币种（境内商户一般是156 人民币）
		if (config.isRealMode())
			requestData.put("txnAmt", param.getTotalPrice()); // 交易金额，单位分，不要带小数点
		else
			requestData.put("txnAmt", "1");// 测试状态的时候使用1做交易
		// requestData.put("reqReserved", "透传字段");
		// //请求方保留域，如需使用请启用即可；透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节

		// 前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
		// 如果想要实现过几秒中自动跳转回商户页面权限，需联系银联业务申请开通自动返回商户权限
		// 异步通知参数详见open.unionpay.com帮助中心 下载 产品接口规范 网关支付产品接口规范 消费交易 商户通知
		requestData.put("frontUrl", config.getFrontUrl());

		// 后台通知地址（需设置为【外网】能访问 http
		// https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
		// 后台通知参数详见open.unionpay.com帮助中心 下载 产品接口规范 网关支付产品接口规范 消费交易 商户通知
		// 注意:1.需设置为外网能访问，否则收不到通知 2.http https均可 3.收单后台通知后需要10秒内返回http200或302状态码
		// 4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
		// 5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d
		// 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
		requestData.put("backUrl", config.getBackUrl());
		
		logger.debug("The requestData total is:"+ util.JsonUtil.stringify(requestData));

		//////////////////////////////////////////////////
		//
		// 报文中特殊用法请查看 PCwap网关跳转支付特殊用法.txt
		//
		//////////////////////////////////////////////////

		/** 请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面 **/
		Map<String, String> submitFromData = AcpService.sign(config,requestData, config.getCharset()); // 报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。

		String requestFrontUrl = config.getFrontRequestUrl(); // 获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
		String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData, config.getCharset()); // 生成自动跳转的Html表单

		LogUtil.writeLog("打印请求HTML，此为请求报文，为联调排查问题的依据：" + html);
		// 将生成的html写到浏览器中完成自动跳转打开银联支付页面；这里调用signData之后，将html写到浏览器跳转到银联页面之前均不能对html中的表单项的名称和值进行修改，如果修改会导致验签不通过

		System.out.println("service pay:" + html);
		return html;
	}

	/**
	 * 获取请求参数中所有的信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				// System.out.println("ServletUtil类247行 temp数据的键=="+en+"
				// 值==="+value);
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}

	protected UnionpayConfig configByAppTotalOrderId(String orderId) throws Exception
	{
		AppPay ap = appPayDao.getByTotalSeriesNumber(orderId);
		if(ap==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的订单信息");
		}
		
		VUnit vunit = vunitDao.getByPortTitleAndAppId("Unionpay", ap.getAppId().intValue());
		if(vunit==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的服务注册信息");
		}
		
		return this.getUnionpayConfig(vunit.getSetting());
	}
	
	protected String fetchFrontRecvUrl(String orderId) throws Exception
	{
		AppPay ap = appPayDao.getByTotalSeriesNumber(orderId);
		if(ap==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的订单信息");
		}
		
		VUnit vunit = vunitDao.getByPortTitleAndAppId("Unionpay", ap.getAppId().intValue());
		if(vunit==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的服务注册信息");
		}
		
		UnionpayConfig config = this.getUnionpayConfig(vunit.getSetting());
		String real_out_trade_no = ap.getOrderSeriesNumber();
		String back_sign = util.MD5.getMD5ofString(vunit.getSeriesNumber() + real_out_trade_no + vunit.getAppSeriesNumber());
		
		String sUrl = config.getRealFrontRecvUrl() +"?back_sign=" + back_sign + "&order_id=" + real_out_trade_no;
		logger.error("UnionpayService.notifyCall url:"+sUrl);
        try {
			URL url = new URL(sUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
			    .getInputStream()));
			String inputLine = in.readLine().toString();
			logger.error("url inputLine:"+inputLine);
			return  inputLine;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	//显示支付成功以后，点击返回商户需要显示的代码的处理，根据orderId得到具体信息，通知前台生成页面信息并返回
	//当前api不对订单的状态做具体变更
	public String unionpayFrontRecvUrl(HttpServletRequest req, HttpServletResponse resp) {
		LogUtil.writeLog("FrontRcvResponse前台接收报文返回开始");
		String encoding = req.getParameter("encoding");
		LogUtil.writeLog("返回报文中encoding=[" + encoding + "]");
		String pageResult = "";
		if ("UTF-8".equals(encoding)) {
			pageResult = "/utf8_result.jsp";
		} else {
			pageResult = "/gbk_result.jsp";
		}
		Map<String, String> respParam = getAllRequestParam(req);
		//所有的返回请求信息都在这里

		// 打印请求报文
		LogUtil.printRequestLog(respParam);

		Map<String, String> valideData = null;
		StringBuffer page = new StringBuffer();
		if (null != respParam && !respParam.isEmpty()) {
			Iterator<Entry<String, String>> it = respParam.entrySet().iterator();
			valideData = new HashMap<String, String>(respParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				try {
					if(value==null)
						value = "";
					else
						value = new String(value.getBytes(encoding), encoding);
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					value = "";
				}

				page.append("<tr><td width=\"30%\" align=\"right\">" + key + "(" + key + ")</td><td>" + value
						+ "</td></tr>");
				valideData.put(key, value);
			}
		}
		String sUrl = "";
		
		UnionpayConfig config;
		try {
			config = this.configByAppTotalOrderId(valideData.get("orderId"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			config = null;
		}
		if (!AcpService.validate(config,valideData, encoding)) { // to be done
			page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>失败</td></tr>");
			LogUtil.writeLog("验证签名结果[失败].");
		} else {
			page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>成功</td></tr>");
			LogUtil.writeLog("验证签名结果[成功].");
			System.out.println(valideData.get("orderId")); // 其他字段也可用类似方式获取
			// 得到本地订单信息，检测 //to be done
			try {
				sUrl = this.fetchFrontRecvUrl(valideData.get("orderId"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//req.setAttribute("result", page.toString());
		/*
		try {
			req.getRequestDispatcher(pageResult).forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		LogUtil.writeLog("FrontRcvResponse前台接收报文返回结束");

		return sUrl;
	}

	
	//支付成功以后，具体处理订单状态的api
	public String unionpayBackRecvUrl(HttpServletRequest req, HttpServletResponse resp) {
		LogUtil.writeLog("BackRcvResponse接收后台通知开始");

		String encoding = req.getParameter(SDKConstants.param_encoding);
		// 获取银联通知服务器发送的后台通知参数
		Map<String, String> reqParam = getAllRequestParam(req);

		LogUtil.printRequestLog(reqParam);

		Map<String, String> valideData = null;
		if (null != reqParam && !reqParam.isEmpty()) {
			Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
			valideData = new HashMap<String, String>(reqParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				try {
					if(value==null)
						value = "";
					else
						value = new String(value.getBytes(encoding), encoding);
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					value = "";
				}
				valideData.put(key, value);
			}
		}

		String sUrl = "";
		
		UnionpayConfig config;
		try {
			config = this.configByAppTotalOrderId(valideData.get("orderId"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			config = null;
		}
		// 重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
		if (!AcpService.validate(config,valideData, encoding)) { // to be done
			LogUtil.writeLog("验证签名结果[失败].");
			// 验签失败，需解决验签问题

		} else {
			LogUtil.writeLog("验证签名结果[成功].");
			// 【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态

			String orderId = valideData.get("orderId"); // 获取后台通知的数据，其他字段也可用类似方式获取
			String respCode = valideData.get("respCode"); // 获取应答码，收到后台通知了respCode的值一般是00，可以不需要根据这个应答码判断。
			String sOk = "";
			if("00".equals(respCode))
			{
				try {
					sOk = fetchBackRecvResponseCode(orderId,valideData);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				resp.getWriter().print(sOk);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LogUtil.writeLog("BackRcvResponse接收后台通知结束");
		return "";
	}

	private String fetchBackRecvResponseCode(String orderId, Map<String, String> valideData) throws Exception{
		AppPay ap = appPayDao.getByTotalSeriesNumber(orderId);
		if(ap==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的订单信息");
		}
		
		VUnit vunit = vunitDao.getByPortTitleAndAppId("Unionpay", ap.getAppId().intValue());
		if(vunit==null){
			throw new Exception("orderId:？:" + orderId + " , 没有对应的服务注册信息");
		}
		if(ap.getIsPaid().equals(1)){
			if(!ap.getPaidPort().equals("Unionpay")){
				appPayDao.addNewNeedRefund("Unionpay",valideData.toString());
				throw new Exception("订单orderId已经被其他方式支付");
			}
		}
		else{
			ap.setPaid(1,"Unionpay",new Date(),valideData.toString());
			appPayDao.setPaid(ap);
		}
		UnionpayConfig config = this.getUnionpayConfig(vunit.getSetting());
		String real_out_trade_no = ap.getOrderSeriesNumber();
		
		String back_sign = util.MD5.getMD5ofString(vunit.getSeriesNumber() + real_out_trade_no + vunit.getAppSeriesNumber());
		
		String sUrl = config.getRealBackRecvUrl() +"?back_sign=" + back_sign + "&order_id=" + real_out_trade_no;
		sUrl += ("&"+"query_id"+"="+ valideData.get("queryId"));
		sUrl += ("&"+"trace_no"+"="+ valideData.get("traceNo"));
		sUrl += ("&"+"acc_no"+"="+ valideData.get("accNo"));
		sUrl += ("&"+"settle_amt"+"="+ valideData.get("settleAmt"));
		logger.error("UnionpayService.notifyCall url:"+sUrl);
        try {
			URL url = new URL(sUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
			    .getInputStream()));
			String inputLine = in.readLine().toString();
			logger.error("url inputLine:"+inputLine);
			return  inputLine;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
