package util;
/**
 *  ConstantsDefine.java
 *  Description:
 *  
 *  CreateDate: 2014年9月11日 下午5:00:52 
 * 
 *  @author yuanhy
 */
public class ConstantsDefine {

//	记录json返回值信息  begin
	public static  String JSON_RESULT_CONTENT_SUCCESS = "操作成功！";
	public static  String JSON_RESULT_NOT_PERMISSION = "操作成功！";
	public final static String CONSTANTS_NET_TIMEOUT = "网络超时，请稍后重试";
	
	/**
	 * 响应码定义 0 成功，1 失败，-1 未登录，2 权限不足
	 * @author wangyongxin
	 *
	 */
	public static class ResponseCode{
		private ResponseCode(){}
		
		public static final int NOT_LOGIN = -1;
		public static final int SUCCESS = 0;
		public static final int FAILURE = 1;
		public static final int NOT_PERMISSION = 2;
	}
}
