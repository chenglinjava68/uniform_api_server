package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	public String getPartner(){
		return partner;
	}
	
	public String getSellerId(){
		return sellerId;
	}
	public String getPrivateKey(){
		return privateKey;
	}
	public String getAliPublicKey(){
		return aliPublicKey;
	}
	public String getLogPath(){
		return logPath;
	}
	public String getInputCharset(){
		return inputCharset;
	}
	public String getSignType(){
		return signType;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	private  String partner = "2088121608978301";
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	private  String sellerId = partner;
	// 商户的私钥
	private  String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALSXEAG3ddNy6SDtenzYl7P6hw7RgaH7S65fzBDCDE91uPsg1ZZ7IoulCJHPJ+IeSysvOvn2GoBFIhjIqBVpbtxU2wXk/QpstXnAJP1gnOz84yLDkpr2jA24z9GQrUx7zSpZUkp3D3fJGPCq9hOhWPG3E+IKOUUkC/5wuh3HiJU/AgMBAAECgYBBtiId7crS+SI5WBBU818oH0Ybr0JTVaRxO+x+QI3IMBbyUj1F92JXm+KlY9KoZcuGWDZGlDWKbR1+FS2MNQQgTZIVNWo7GzYcLrPVsy8n5gi9u4wu5i9a61mUBmLXtecIZQFDnzpw8bzq1IqnNvVnhtyix5j7UvP0LQdeEj47oQJBAOKvYVmNNQ10kmJEO2fN3gKyPpIGeIe/deLhW9ASAElN3vjWNta4ZcregrB8bo0GLRn1YaU0Yk9pwZhSJLm7MQ8CQQDL8aoyXOxiJlHGaoyWBqTb2MI5fgYWk0x6eUsELL8byNZipWZrv4gex0+dV8y3sbb88F2sviy+E4jZnQZQ4fjRAkEAij+NrpDo9yDOGfIlDMTIDnrooCQkJB4HZmwsk3Q3Cn3ca4Qxg7iIFDaqG7p3rbhDj15Qw/Fzt5z2/c+zKDbazwJAdiCcPF+ma5NWel7s31kp1E1Q8owUaq8W9TmcQebJKwbBZpH3KSHfbjRz4OciJKRDIW74Uz40HESkV6ekKOU6gQJAGuSAZCXbNUGwRL2d9FDTvEjipz/5udtTp5diuyQmwz0TqVEOJwg+ChwRGz69172secqzqgW2iLova/n1FZDBqw==";
	// 支付宝的公钥，无需修改该值
	private  String aliPublicKey  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 调试用，创建TXT日志文件夹路径
	private  String logPath = "D:\\";
	// 字符编码格式 目前支持 gbk 或 utf-8
	private  String inputCharset = "utf-8";
	// 签名方式 不需修改
	private  String signType = "RSA";
	private  String notifyUrl = "http://101.200.232.199:10000/api/alipay/notify_url";
	private String returnUrl = "http://101.200.232.199:10000/api/alipay/return_url";
	private String realNotifyUrl = "http://beta.woigo.cn/qqvisa/api/alipay/notify_url";
	private String realReturnUrl = "http://beta.woigo.cn/qqvisa/api/alipay/return_url";
	
	public String getRealNotifyUrl() {
		return realNotifyUrl;
	}

	public void setRealNotifyUrl(String realNotifyUrl) {
		this.realNotifyUrl = realNotifyUrl;
	}

	public String getRealReturnUrl() {
		return realReturnUrl;
	}

	public void setRealReturnUrl(String realReturnUrl) {
		this.realReturnUrl = realReturnUrl;
	}

	private boolean isRealMode = true;

	protected AlipayConfig(){

	}
	public static AlipayConfig newConfig(String partner,String privateKey,String aliPublicKey,String logPath,String inputCharset,String signType,String notifyUrl,String return_url)
	{
		AlipayConfig cfg = new AlipayConfig();
		cfg.partner = partner;
		cfg.privateKey = privateKey;
		cfg.sellerId = partner;
		cfg.aliPublicKey =aliPublicKey;
		cfg.logPath = logPath;
		cfg.inputCharset = inputCharset;
		cfg.signType = signType;
		cfg.notifyUrl = notifyUrl;
		cfg.returnUrl = return_url;
	 	return cfg;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String val) {
		this.returnUrl = val;
	}

	public boolean isRealMode() {
		return isRealMode;
	}

	public void setRealMode(boolean isRealMode) {
		this.isRealMode = isRealMode;
	}
}
