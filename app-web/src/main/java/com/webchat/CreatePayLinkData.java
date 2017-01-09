package com.webchat;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreatePayLinkData {
/*java.util.Map<String,Object> kks = new java.util.HashMap<String,Object>();
		kks.put("appid",config.getAppid());
		kks.put("mch_id",config.getMchId());
		String timeStamp = ((new Date()).getTime() / 1000)+"";
		kks.put("time_stamp", timeStamp);
		String nonceStr = util.Random.generateWithCharNumber(12);
		kks.put("nonce_str", nonceStr);
		kks.put("product_id", productId);*/
	private String appid;
	private String mch_id;
	private String time_stamp;
	private String nonce_str;
	private String product_id;
	private String sign = null;
	public static String getPayLink(String appid,String mchId, String productId,String wechatKey){
		CreatePayLinkData cpld = new CreatePayLinkData();
		cpld.appid = appid;
		cpld.mch_id = mchId;
		cpld.product_id = productId;
		return cpld.toPayLink(wechatKey);
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
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String toPayLink(String wechatKey){
		this.time_stamp = ((new Date()).getTime() / 1000)+"";
		this.nonce_str = util.Random.generateWithCharNumber(12);
		this.sign = Signature.getSign(this.toMap(), wechatKey);
		String payLink = "weixin://wxpay/bizpayurl?";
		boolean bFirst = true;
		Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                	if(!bFirst)
                		payLink += "&";
                	bFirst = false;
                	payLink+= (field.getName() +"="+ obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
		return payLink;
	}
	public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
