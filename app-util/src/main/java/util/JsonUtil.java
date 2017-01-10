package util;


import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class JsonUtil {
	
	public static String stringify(Object obj) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
	       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	       mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
	       mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	    return mapper.writeValueAsString(obj);
	}

	public static Object parseString(String data, Class sClass){
    		ObjectMapper mapper = new ObjectMapper();
    	       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	       mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
    	       mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    		Object oo = null;
    		try{
    			oo = mapper.readValue(data, sClass);
    		}
    		catch(Exception e){
    			oo = null;
    		}
    		return oo;
    	}
	public static Map<String,Object> parseString(String data){
		ObjectMapper mapper = new ObjectMapper();
	       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	       mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
	       mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	       Map<String,Object> oo = null;
		try{
			oo = mapper.readValue(data, Map.class);
		}
		catch(Exception e){
			oo = null;
		}
		return oo;
	}
	
	
	public static Boolean setBooleanByObject(Object obj){
		if(obj.getClass().getName().equals("java.lang.Boolean"))
			return (Boolean)obj;
		if(obj.getClass().getName().equals("java.lang.Integer"))
			return (((Integer)obj).intValue() == 1);
		return false;
	}
	public static Object get(Boolean val,boolean isForJsonOutput){
		if(isForJsonOutput){			
			return val;
		}
		else{
			if(val)
				return 1;
			else
				return 0;
		}
	}
	public static Object getS(java.util.Date val,boolean isForJsonOutput){		
		if(isForJsonOutput){			
			if (null != val )
			{
				try
				{
					return DateUtil.DateToStringSecond(val);
				} catch (Exception e) {
					return "";
				}
			} else {
				return "";
			}
		}
		else{
			return val;
		}
	}
	
	public static Object getm(java.util.Date val,boolean isForJsonOutput){		
		if(isForJsonOutput){			
			if (null != val )
			{
				try
				{
					return DateUtil.DateToStringM(val);
				} catch (Exception e) {
					return "";
				}
			} else {
				return "";
			}
		}
		else{
			return val;
		}
	}
	
	public static Object get(java.util.Date val,boolean isForJsonOutput){		
		if(isForJsonOutput){			
			if (null != val )
			{
				try
				{
					return DateUtil.DateToString(val);
				} catch (Exception e) {
					return "";
				}
			} else {
				return "";
			}
		}
		else{
			return val;
		}
	}
	
	
	public static Object get(String val,boolean isForJsonOutput){		
		if(isForJsonOutput){			
			if (null != val && !val.isEmpty())
			{
				try
				{
					return (JSON)JSONObject.parse(val);
				} catch (Exception e) {
					return "";
				}
			} else {
				return "";
			}
		}
		else{
			return val;
		}
	}
	public static Object get(Integer val,boolean isForJsonOutput){
		if(isForJsonOutput){			
			Boolean bFlag = (val==1);
			return bFlag;
		}
		else{
			return val;
		}
	}
}
