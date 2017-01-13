package com.dos.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.Map;

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
}
