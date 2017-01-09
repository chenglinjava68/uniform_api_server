package com.webchat;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class NativeNotifyReturnData {
	private String return_code = "SUCCESS";
	private String return_msg = "";
	private String appid;
	private String mch_id;
	private String nonce_str;
	private String prepay_id;
	private String result_code = "SUCCESS";
	private String err_code_des = "";
	private String sign;
	public static NativeNotifyReturnData init(String appid,String mch_id){
		NativeNotifyReturnData returnData = new NativeNotifyReturnData();
		returnData.setAppid(appid);
		returnData.setMch_id(mch_id);
		returnData.setNonce_str(util.Random.generateWithCharNumber(12));
		return returnData;
	}
	public void sysError(String returnMsg){
		this.return_code = "FAIL";
		this.return_msg = returnMsg;
		this.err_code_des = returnMsg;
	}
	public void error(String msg){
		this.result_code = "FAIL";
		this.err_code_des = msg;
	}
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public void MakeSign(String key){
		String makeSign = Signature.getSign(this.toMap(), key);
		this.sign = makeSign;
	}
    public Map<String,Object> toMap(){
            Map<String,Object> map = new HashMap<String, Object>();
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                Object obj;
                try {
                    obj = field.get(this);
                    if(obj!=null && !field.getName().equals("sign")){
                        map.put(field.getName(), obj);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return map;
    }
	public String toXml(){
            String sXml = "<xml>";
            Field[] fields = this.getClass().getDeclaredFields();
           for (Field field : fields) {
                            Object obj;
                            try {
                                obj = field.get(this);
                                if(obj!=null){
                                    sXml +="<"+field.getName()+">"+obj+"</"+field.getName()+">";
                                }
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                        sXml +="</xml>";
           return sXml;
	}
}
