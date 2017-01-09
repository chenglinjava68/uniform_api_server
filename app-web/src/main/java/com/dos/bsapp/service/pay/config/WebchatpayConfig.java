package com.dos.bsapp.service.pay.config;

public class WebchatpayConfig
{
	private String appid="wx2b713952a886ea6b";
	private String mchId="1347657201";
	public String getAppid() { return appid; }
	public void setAppid(String val){ appid = val; }
	public String getMchId() { return mchId; }
	public void setMchId(String val) { mchId = val; }
	private String key;
	public String getKey() { return key; }
	public void setKey(String val) { key = val; }
	private String localIp;
	public String getLocalIp(){ return localIp; }
	public void setLocalIp(String val){ localIp = val; }
	private String notifyUrl="http://101.200.232.199:10000/api/wechatpay/native_notify";
	public String getNotifyUrl() { return notifyUrl; }
	public void setNotifyUrl(String val) { notifyUrl = val; }
	
	private String realNotifyUrl = "http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url";
	public String getRealNotifyUrl() {
		return realNotifyUrl;
	}
	public void setRealNotifyUrl(String realNotifyUrl) {
		this.realNotifyUrl = realNotifyUrl;
	}
	private Integer isDebug = 0;
	public Integer getIsDebug() {
		return isDebug;
	}
	public void setIsDebug(Integer isDebug) {
		this.isDebug = isDebug;
	}
	public boolean isDebug() {
		return this.isDebug.equals(1);
	}
	

}
