package com.dos.bsapp.model;

import java.util.Date;

import util.DateUtil;

public class Unit extends BaseEntity
{
    private Integer appId;
    public Integer getAppId(){ return this.appId; }
    public void  setAppId(Integer val ){  this.appId = val ; }

    private Integer portId;
    public Integer getPortId(){ return this.portId; }
    public void  setPortId(Integer val ){  this.portId = val ; }

    private String setting;
    public String getSetting(){ return this.setting; }
    public void  setSetting(String val ){  this.setting = val ; }

    private Integer isLock = 0;
    public Integer getIsLock(){ return this.isLock; }
    public void  setIsLock(Integer val ){  this.isLock = val ; }

    private String seriesNumber="";
    public String getSeriesNumber(){ return this.seriesNumber; }
    public void  setSeriesNumber(String val ){  this.seriesNumber = val ; }

    private Date created;
    public Date getCreated(){ return this.created; }
    public  String getCreatedDesc(){ return DateUtil.toString(this.created); }
    public void  setCreated(Date val ){  this.created = val ; }
    
	public static Unit addUnit(int app, int port, String st) {
		Unit ut = new Unit();
		ut.appId = app;
		ut.portId = port;
		ut.setting = st;
		ut.isLock = 0;
		ut.created = new Date();
		return ut;
	}

}