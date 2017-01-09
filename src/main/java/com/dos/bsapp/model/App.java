package com.dos.bsapp.model;

import java.util.Date;
public class App extends BaseEntity
{
    private String title;
        public String getTitle(){ return this.title; }
        public void  setTitle(String val ){  this.title = val ; }

        private String seriesNumber;
        public String getSeriesNumber(){ return this.seriesNumber; }
        public void  setSeriesNumber(String val ){  this.seriesNumber = val ; }

        private Integer isLock = 0;
        public Integer getIsLock(){ return this.isLock; }
        public void  setIsLock(Integer val ){  this.isLock = val ; }

        private Date created;
        public Date getCreated(){ return this.created; }
        public  String getCreatedDesc(){ return util.DateUtil.toString(this.created); }
        public void  setCreated(Date val ){  this.created = val ; }

    public static App addApp(String title){
        App ap = new App();
        ap.id = 0;
        ap.title = title;
        ap.seriesNumber = "";
        ap.isLock = 0;
        ap.created = new Date();
        return ap;
    }

}