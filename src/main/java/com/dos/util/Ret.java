package com.dos.util;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;

public class Ret
{
    private Integer code = 0;
    private String  message = "";
    private Object  data = null;
    private Integer status = 200;
    private Date    timestamp = new Date();
    public static Ret ok(Object out){
        Ret r = new Ret();
        r.message = "";
        r.data = out;
        return r;
    }
    public static Ret ok(String msg, Object out){
        Ret r = new Ret();
        r.message = msg;
        r.data = out;
        return r;
    }
    public static Ret no(String msg){
        Ret r = new Ret();
        r.code = 1;
        r.message = msg;
        r.data = null;
        return r;
    }
    public static Ret auth(String msg){
        Ret r = new Ret();
        r.code = -1;
        r.message = msg;
        r.data = null;
        return r;
    }
    public static Ret no(Integer sc, String msg){
        Ret r = new Ret();
        r.code = sc;
        r.message = msg;
        r.data = null;
        return r;
    }
    public void setStatus(Integer v) { status = v; }
    public Integer getStatus() { return status; }
    public Date getTimestamp() { return timestamp; }
    public boolean cOk(){
    	return code==0;
    }
    public boolean cFalse(){
    	return code != 0;
    }
    public boolean check() throws Exception{
    	if(cFalse())
    		throw new Exception(getMessage());
    	return cOk();
    }
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String msg) {
		this.message = msg;
	}
	public Object getData() {
		return data;
	}
	//public static <T> T getEntity(String jsonString, Class<T> prototype)
	public <T> T getT(Class<T> prototype){
		return ((T)data);
	}
	
	public void setData(Object out) {
		this.data = out;
	}
	
	public String json(){
		try {
			return JsonUtil.stringify(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
    
}
