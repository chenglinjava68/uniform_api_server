package util;


public class JO {
	private Integer ret = 0;
	private String message = "";
	private Object data = null;
	private Object global = null;
	public Integer getRet() { return this.ret; }
	public void setRet(Integer val){ this.ret = val; }
	public Object getData() { return this.data; }
	public void setData(Object val){ this.data = val; }
	public Object getGlobal() { return this.global; }
	public void setGlobal(Object val){ this.global = val; }

	public static JO ok(String msg, Object data,Object global){
		JO jo = new JO();
		if(msg != null)
			jo.message = msg;
		jo.data = data;
		if(global != null)
			jo.global = global;
		return jo;
	}
	public static JO ok(Object data){
        return ok(null,data,null);
    }
	public static JO ok(String msg,Object data){
        return ok(msg,data,null);
    }
	public static JO fail(String msg){
    		JO jo = new JO();
    		jo.message = msg;
    		jo.ret = 1;
    		return jo;
    }
    public static JO needLogin(String msg){
        		JO jo = new JO();
        		jo.message = msg;
        		jo.ret = -1;
        		return jo;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
};
