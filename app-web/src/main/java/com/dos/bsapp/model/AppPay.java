package com.dos.bsapp.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Date;


public class AppPay extends BaseEntity
{
    private Integer appId;
    private String orderSeriesNumber;
    private String totalSeriesNumber;

    public Integer getAppId() { return this.appId; }
    public String getOrderSeriesNumber() { return this.orderSeriesNumber; }
    public void setAppId(Integer val ){ this.appId = val; }
    public void setOrderSeriesNumber(String val){ this.orderSeriesNumber = val; }
    private Date created;
    public Date getCreated(){ return this.created;}
    public void setCreated(Date d){ this.created = d; }

    private Integer isPaid = 0; // isPaid = 0/1
    public Integer getIsPaid() { return isPaid; }
    public void setIsPaid(Integer val ) { this.isPaid = val; }
    private String paidPort = ""; //alipay,wechatpay,...
    public String getPaidPort() { return paidPort; }
    public void setPaidPort(String val){ paidPort = val; }
    private Date paidTime = null;
    public Date getPaidTime() { return paidTime; }
    public void setPaidTime(Date val){ paidTime = val; }
    private String paidInfo = "";
    public String getPaidInfo() { return paidInfo; }
    public Object getPaidInfoDesc() {
        if(paidInfo == null || paidInfo == ""){
            return JSONObject.parse("{}");
        }
        else{
            return JSONObject.parse(paidInfo);
        }
    }
    public void setPaidInfo(String val){
        this.paidInfo = val;
    }
    private Integer regUnit;

    public static AppPay newPay(Integer appId,String appSeriesNumber,String order,Integer regUnit) throws Exception{
        if( order == null || order == "")
            throw new Exception("App和Order信息错误。");
        AppPay ap = new AppPay();
        ap.setId(appId.intValue());
        ap.appId = appId;
        ap.orderSeriesNumber = order;
        ap.created = new Date();
        ap.setTotalSeriesNumber(appSeriesNumber+order);
        ap.setRegUnit(regUnit);
        return ap;
    }
	public Integer getRegUnit() {
		return regUnit;
	}
	public void setRegUnit(Integer regUnit) {
		this.regUnit = regUnit;
	}
	public String getTotalSeriesNumber() {
		return totalSeriesNumber;
	}
	public void setTotalSeriesNumber(String totalSeriesNumber) {
		this.totalSeriesNumber = totalSeriesNumber;
	}
	public void setPaid(int isPaid, String paidPort, Date date, String paidInfo) {
		this.setIsPaid(isPaid);
		this.setPaidPort(paidPort);
		this.setPaidTime(date);
		this.setPaidInfo(paidInfo);
	}
	
	private String wechatPayLink;
	public String getWechatPayLink() {
		/*
		if(this.wechatPayLinkCreateTime == null || this.wechatPayLink == null ){
			return null;
		}
		else{
			Date now = new Date();
			if( now.getTime() - this.wechatPayLinkCreateTime.getTime() <   1000*60*60*1.75)
				return wechatPayLink;
			else
				return null;
		}*/
		return this.wechatPayLink;
	}
	public void setWechatPayLink(String wechatPayLink) {
		this.wechatPayLink = wechatPayLink;
	}
	private String orderName;
	private Integer totalPrice;
	private String showUrl;
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
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
	private String overTime;
	public void setWechatPayLink(String sLink, String orderName, String totalPrice, String showUrl, String overTime) {
		this.wechatPayLink = sLink;
		this.orderName = orderName;
		Float ft = Float.parseFloat(totalPrice);
		ft = ft*100;
		this.totalPrice = ft.intValue();
		this.showUrl = showUrl;
		this.overTime = overTime;
	}
	private String wechatPrepareId = "";
	private Date wechatPrepareIdCreateTime = null;
	public String getUsableWechatPrepareId() {
		if(this.wechatPrepareIdCreateTime == null || this.wechatPrepareId == null ){
			return null;
		}
		else{
			Date now = new Date();
			if( now.getTime() - this.wechatPrepareIdCreateTime.getTime() <   1000*60*60*1.85)
				return wechatPrepareId;
			else
				return null;
		}
	}
	public void setUsableWechatPrepareId(String prepay_id) {
		this.wechatPrepareId = prepay_id;
		this.wechatPrepareIdCreateTime = new Date();
	}
	public String getWechatPrepareId() {
		return wechatPrepareId;
	}
	public void setWechatPrepareId(String wechatPrepareId) {
		this.wechatPrepareId = wechatPrepareId;
	}
	public Date getWechatPrepareIdCreateTime() {
		return wechatPrepareIdCreateTime;
	}
	public void setWechatPrepareIdCreateTime(Date wechatPrepareIdCreateTime) {
		this.wechatPrepareIdCreateTime = wechatPrepareIdCreateTime;
	}
	private Integer calledBack = 0;
	private Date calledBackTime = null;
	public Date getCalledBackTime() {
		return calledBackTime;
	}
	public void setCalledBackTime(Date calledBackTime) {
		this.calledBackTime = calledBackTime;
	}
	public Integer getCalledBack() {
		return calledBack;
	}
	public void setCalledBack(Integer calledBack) {
		this.calledBack = calledBack;
		this.calledBackTime = new Date();
	}
	
	
	

}