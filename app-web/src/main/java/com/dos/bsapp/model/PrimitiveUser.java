package com.dos.bsapp.model;


public class PrimitiveUser
{
    private Integer id;
    private String sn;    //user序列号，所有的app唯一
    private String password;
    private String nick;
    private String phone;
    private Date created;
    public Integer getId() { return id; }
    public void setId(Integer val){ id = val; }
    public String getSn() { return sn; }
    public void setSn(String val){ sn = val; }
}