package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

//import com.intelgoo.qqvisa.po.$missing$;


public class JsonUtil {
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

	public static String stringify(Object obj) throws Exception{
    		ObjectMapper mapper = new ObjectMapper();
    	       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	       mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
    	       mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    	    return mapper.writeValueAsString(obj);
    	}

}
