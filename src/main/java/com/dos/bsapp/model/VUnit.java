package com.dos.bsapp.model;

import java.util.Date;

public class VUnit extends BaseEntity
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
    public  String getCreatedDesc(){ return util.DateUtil.toString(this.created); }
    public void  setCreated(Date val ){  this.created = val ; }

    private String appSeriesNumber;
    public String getAppSeriesNumber(){ return appSeriesNumber; }
    public void setAppSeriesNumber(String val){ this.appSeriesNumber = val ; }
    private String appTitle;
    public String getAppTitle() { return this.appTitle; }
    public void setAppTitle(String val) { this.appTitle = val;}
    private String portTitle;
    public String getPortTitle() { return this.portTitle; }
    public void setPortTitle(String val) { this.portTitle = val; }
    private Integer appIsLock = 0;
    public Integer getAppIsLock() { return this.appIsLock; }
    public void setAppIsLock(Integer val){ this.appIsLock = val; }
    private Integer portIsLock = 0;
    public Integer getPortIsLock() { return this.portIsLock; }
    public void setPortIsLock(Integer val){ this.portIsLock = val; }

    public boolean isUsable(){
        return isLock.equals(0) && appIsLock.equals(0) && portIsLock.equals(0);
    }
}