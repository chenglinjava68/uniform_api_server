package com.dos.bsapp.model;

public class AlipayCallbackLog {
	private Integer id = 0;
	private String fromMethod = "";
	private String inputParam = "";
	private String outTradeNo = "";
	private Integer appId = 0;
	private String 	appSeriesNumber = "";
	private Integer unitId = 0;
	private String unitSeriesNumber = "";
	private String tradeNo = "";
	private String tradeStatus = "";
	private String buyerEmail = "";
	private String buyerId = "";
	private String backSign = "";
	private String returnUrl = "";
	private String notifyUrl = "";
	private String errorException = "";
	private Integer needRefund = 0;
	private String callClientUrl = "";
	private String callClientReturn = "";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFromMethod() {
		return fromMethod;
	}
	public void setFromMethod(String fromMethod) {
		this.fromMethod = fromMethod;
	}
	public String getInputParam() {
		return inputParam;
	}
	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAppSeriesNumber() {
		return appSeriesNumber;
	}
	public void setAppSeriesNumber(String appSeriesNumber) {
		this.appSeriesNumber = appSeriesNumber;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitSeriesNumber() {
		return unitSeriesNumber;
	}
	public void setUnitSeriesNumber(String unitSeriesNumber) {
		this.unitSeriesNumber = unitSeriesNumber;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getBackSign() {
		return backSign;
	}
	public void setBackSign(String backSign) {
		this.backSign = backSign;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getErrorException() {
		return errorException;
	}
	public void setErrorException(String errorException) {
		this.errorException = errorException;
	}
	public Integer getNeedRefund() {
		return needRefund;
	}
	public void setNeedRefund(Integer needRefund) {
		this.needRefund = needRefund;
	}
	public String getCallClientUrl() {
		return callClientUrl;
	}
	public void setCallClientUrl(String callClientUrl) {
		this.callClientUrl = callClientUrl;
	}
	public String getCallClientReturn() {
		return callClientReturn;
	}
	public void setCallClientReturn(String callClientReturn) {
		this.callClientReturn = callClientReturn;
	}
}
