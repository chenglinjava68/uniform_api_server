package com.webchat;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class NotifyResData {

    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String appid = "";
    private String mch_id = "";
    private String device_info;
    private String nonce_str;
    private String sign;
    private String err_code;
    private String err_code_des;
    private String openid;
    private String is_subscribe;
    private String trade_type;
    private String back_type;
    private String total_fee;
    private String settlement_total_fee;
    private String fee_type;
    private String cash_fee;
    private String cash_fee_type;
    private String coupon_fee;
    private String coupon_count;
    private String coupon_type_$0 = null;
    private String coupon_type_$1 = null;
    private String coupon_type_$2 = null;
    private String coupon_type_$3 = null;
    private String coupon_type_$4 = null;
    
    private String coupon_id_$0 = null;
    private String coupon_id_$1 = null;
    private String coupon_id_$2 = null;
    private String coupon_id_$3 = null;
    private String coupon_id_$4 = null;
    
    private String coupon_fee_$0 = null;
    private String coupon_fee_$1 = null;
    private String coupon_fee_$2 = null;
    private String coupon_fee_$3 = null;
    private String coupon_fee_$4 = null;
    
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
    
    
    public boolean verifySign(String key){
		boolean isVerify = false;
		String makeSign = Signature.getSign(this.toMap(), key);
		isVerify = this.sign.equals(makeSign);
		return isVerify;
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
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getBack_type() {
		return back_type;
	}
	public void setBack_type(String back_type) {
		this.back_type = back_type;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSettlement_total_fee() {
		return settlement_total_fee;
	}
	public void setSettlement_total_fee(String settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public String getCoupon_fee() {
		return coupon_fee;
	}
	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public String getCoupon_count() {
		return coupon_count;
	}
	public void setCoupon_count(String coupon_count) {
		this.coupon_count = coupon_count;
	}
	public String getCoupon_type_$0() {
		return coupon_type_$0;
	}
	public void setCoupon_type_$0(String coupon_type_$0) {
		this.coupon_type_$0 = coupon_type_$0;
	}
	public String getCoupon_type_$1() {
		return coupon_type_$1;
	}
	public void setCoupon_type_$1(String coupon_type_$1) {
		this.coupon_type_$1 = coupon_type_$1;
	}
	public String getCoupon_type_$2() {
		return coupon_type_$2;
	}
	public void setCoupon_type_$2(String coupon_type_$2) {
		this.coupon_type_$2 = coupon_type_$2;
	}
	public String getCoupon_type_$3() {
		return coupon_type_$3;
	}
	public void setCoupon_type_$3(String coupon_type_$3) {
		this.coupon_type_$3 = coupon_type_$3;
	}
	public String getCoupon_type_$4() {
		return coupon_type_$4;
	}
	public void setCoupon_type_$4(String coupon_type_$4) {
		this.coupon_type_$4 = coupon_type_$4;
	}
	public String getCoupon_id_$1() {
		return coupon_id_$1;
	}
	public void setCoupon_id_$1(String coupon_id_$1) {
		this.coupon_id_$1 = coupon_id_$1;
	}
	public String getCoupon_id_$0() {
		return coupon_id_$0;
	}
	public void setCoupon_id_$0(String coupon_id_$0) {
		this.coupon_id_$0 = coupon_id_$0;
	}
	public String getCoupon_id_$2() {
		return coupon_id_$2;
	}
	public void setCoupon_id_$2(String coupon_id_$2) {
		this.coupon_id_$2 = coupon_id_$2;
	}
	public String getCoupon_id_$3() {
		return coupon_id_$3;
	}
	public void setCoupon_id_$3(String coupon_id_$3) {
		this.coupon_id_$3 = coupon_id_$3;
	}
	public String getCoupon_id_$4() {
		return coupon_id_$4;
	}
	public void setCoupon_id_$4(String coupon_id_$4) {
		this.coupon_id_$4 = coupon_id_$4;
	}
	public String getCoupon_fee_$0() {
		return coupon_fee_$0;
	}
	public void setCoupon_fee_$0(String coupon_fee_$0) {
		this.coupon_fee_$0 = coupon_fee_$0;
	}
	public String getCoupon_fee_$1() {
		return coupon_fee_$1;
	}
	public void setCoupon_fee_$1(String coupon_fee_$1) {
		this.coupon_fee_$1 = coupon_fee_$1;
	}
	public String getCoupon_fee_$2() {
		return coupon_fee_$2;
	}
	public void setCoupon_fee_$2(String coupon_fee_$2) {
		this.coupon_fee_$2 = coupon_fee_$2;
	}
	public String getCoupon_fee_$3() {
		return coupon_fee_$3;
	}
	public void setCoupon_fee_$3(String coupon_fee_$3) {
		this.coupon_fee_$3 = coupon_fee_$3;
	}
	public String getCoupon_fee_$4() {
		return coupon_fee_$4;
	}
	public void setCoupon_fee_$4(String coupon_fee_$4) {
		this.coupon_fee_$4 = coupon_fee_$4;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
