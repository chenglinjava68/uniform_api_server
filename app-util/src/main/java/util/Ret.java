package util;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Ret
{
    private boolean code = false;
    private String  message = "";
    private Object  data = null;
    public static Ret ok(Object out){
        Ret r = new Ret();
        r.code = true;
        r.message = "";
        r.data = out;
        return r;
    }
    public static Ret ok(String msg, Object out){
        Ret r = new Ret();
        r.code = true;
        r.message = msg;
        r.data = out;
        return r;
    }
    public static Ret no(String msg){
        Ret r = new Ret();
        r.code = false;
        r.message = msg;
        r.data = null;
        return r;
    }
    public boolean cOk(){
    	return code;
    }
    public boolean cFalse(){
    	return !code;
    }
    public boolean check() throws Exception{
    	if(cFalse())
    		throw new Exception(getMessage());
    	return cOk();
    }
	public boolean isCode() {
		return code;
	}
	public void setCode(boolean code) {
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
			return util.JsonUtil.stringify(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
    
}
