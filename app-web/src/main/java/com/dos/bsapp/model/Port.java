package com.dos.bsapp.model;
import java.util.Date;
public class Port extends BaseEntity
{
     private String title;
        public String getTitle(){ return this.title; }
        public void  setTitle(String val ){  this.title = val ; }

        private String setting;
        public String getSetting(){ return this.setting; }
        public void  setSetting(String val ){  this.setting = val ; }

        private Integer isLock = 0;
        public Integer getIsLock(){ return this.isLock; }
        public void  setIsLock(Integer val ){  this.isLock = val ; if(this.isLock == null) this.isLock = 0;  }

        private Date created;
        public Date getCreated(){ return this.created; }
        public  String getCreatedDesc(){ return util.DateUtil.toString(this.created); }
        public void  setCreated(Date val ){  this.created = val ; }

    public static Port addPort(String title, String setting){
        Port p = new Port();
        p.setId(0);
        p.setTitle(title);
        p.setSetting(setting);
        p.created = new Date();
        return p;
    }

}