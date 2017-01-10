package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
 * @author wujianguo 
 * @version V1.1 
 * 类说明 
 */
public class StringUtil {
	
	/**
	 * @Description:  判断一个字符串是否不为null也不为空串
	 * @author JianGuo Wu   
	 * @param str 要判断的字符串
	 * @return true：不为null也不为空串； false：为null或者为空串
	 */
	public static boolean notNullandEmpty(String str){
		if(null != str && str.length() != 0){
			return true;
		}
		return false;
	}
	
	public static List<Long> parseIds(String str){
		java.util.ArrayList<Long> al = new java.util.ArrayList<>();
		try
		{
			JSONArray ja  = JSONObject.parseArray(str);
			Object[] idIndex = (Object[]) ja.toArray();
			if(idIndex != null && idIndex.length>0){
				if(idIndex.length == 1)
				{
					java.lang.Integer ai = (java.lang.Integer)idIndex[0];
					al.add(ai.longValue());
				}
				else
				{
					for(Object ii : idIndex){
						java.lang.Integer ai = (java.lang.Integer)ii;
						al.add(ai.longValue());
					}
				}
			}
		}
		catch(Exception e){
			return al;
		}
		return al;
	}
	
	/**
	 * @Description: 判断一个Integer类型数据是否不为null
	 * @author JianGuo Wu   
	 * @param iVal 要判断的Integer类型数据
	 * @return true：不为null； false：为null
	 */
	public static boolean notNullandEmpty(Integer iVal){
		if(null != iVal){
			return true;
		}
		return false;
	}

	/**
	 * @Description:  将一个字符串形式的数据转化成List<Long>形式    
	 * @param:        idStrs 字符串，如“[1,2,4,5]”形式
	 * @param:        @return       
	 * @return:       List<Long>       
	 * @throws    
	 * @author        wujianguo    
	 */
	public static List<Long> getListByStr(String idStrs) {
		List<Long> resultList = new ArrayList<Long>();
		String strTrim = idStrs.trim();
		if(strTrim.startsWith("[") && strTrim.endsWith("]")){
			strTrim = strTrim.replace("[", "").replace("]", "");
		}
		if(strTrim.length() > 0){
			String[] result = strTrim.split(",");
			List<String> resultStrType = Arrays.asList(result);
			resultList = StringToIntegerLst(resultStrType);
		}
		return resultList;
	}
	
	/**
	 * @Description:  将List<String>转化为List<Long>   
	 * @param:        @param inList
	 * @param:        @return       
	 * @return:       List<Integer>       
	 * @author        wujianguo    
	 */
	public static List<Long> StringToIntegerLst(List<String> inList){
		List<Long> iList =new ArrayList<Long>(inList.size());
		for(int i=0,j=inList.size();i<j;i++){
			iList.add(Long.parseLong(inList.get(i)));   
		}   
        return iList;
    }
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}

	/**
	 * @Description:  将一个字符串形式的数据转化成List<String>形式  
	 * @param:        str 字符串，如“["usa","japan"]”形式
	 * @param:        @return       
	 * @return:       List<String>       
	 * @author        wujianguo    
	 */
	public static List<String> getStrListByStr(String str) {
		List<String> resultList = new ArrayList<String>();
		String strTrim = str.trim();
		if(strTrim.startsWith("[") && strTrim.endsWith("]")){
			strTrim = strTrim.replace("[", "").replace("]", "");
		}
		if(strTrim.length() > 0){
			String[] result = strTrim.split(",");
			List<String> resultStrType = Arrays.asList(result);
			for(String s : resultStrType){
				s = s.trim();
				if((s.startsWith("'") && s.endsWith("'"))||(s.startsWith("\"") && s.endsWith("\"")))
					resultList.add(s.substring(1, s.length()-1));
				else
					resultList.add(s.substring(0, s.length()));
			}
		}
		return resultList;
	}
	
	public static String getGenderDesc(String val){
		if("male".equals(val))
			return "男";
		if("female".equals(val))
			return "女";
		return "未设定";
	}
	public static String getUserRoleDesc(String userRole){
		
	    if (userRole.equals("eu"))  return "企业用户";
	    if (userRole.equals("nu"))  return "普通用户";
	    if (userRole.equals("bu"))  return "团体用户";
	    if (userRole.equals("em"))  return "企业管理员";
	    return "未设定";
	}
	public static String getManagerRoleDesc(String userRole){
		if (userRole.equals("A"))  return "经理";
	    if (userRole.equals("B"))  return "填表员";
	    if (userRole.equals("C"))  return "开表员";
	    if (userRole.equals("D"))  return "送签员";
	    if (userRole.equals("E"))  return "兼职人员";
	    if (userRole.equals("admin"))  return "管理员";
	    return "未设定";
	    
	}
	
	
}
