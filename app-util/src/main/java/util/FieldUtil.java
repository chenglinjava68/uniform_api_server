package util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class FieldUtil {
	public static void filter(Object obj,List<String> resverseFs){
		Field[] fields = obj.getClass().getDeclaredFields();  
	    for (Field field : fields)  
	    {  
	        // 对于每个属性，获取属性名  
	        String varName = field.getName();  
	        boolean isExist = false;
	        for(String rf : resverseFs){
	        	if(rf.equals(varName))
	        		isExist = true;
	        }
	        if(!isExist){
	        	try  
		        {  
		        	
	        		if((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
		            	continue;
		            boolean access = field.isAccessible();
		            if(!access) field.setAccessible(true);
		            
		            if(field.getType().equals(java.lang.String.class))
		            	field.set(obj, "");
		            	
		            if(!access) field.setAccessible(false);
		            	        
		        }  
	        	catch(java.lang.IllegalArgumentException ee){
	        		
	        	}
		        catch (Exception ex)  
		        {  
		            ex.printStackTrace();  
		        } 
	        }
	    }
	    
	    fields = obj.getClass().getSuperclass().getDeclaredFields();  
	    for (Field field : fields)  
	    {  
	        // 对于每个属性，获取属性名  
	        String varName = field.getName();  
	        boolean isExist = false;
	        for(String rf : resverseFs){
	        	if(rf.equals(varName))
	        		isExist = true;
	        }
	        if(!isExist){
	        	try  
		        {  
		        	
		            if((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
		            	continue;
		            boolean access = field.isAccessible();
		            if(!access) field.setAccessible(true);
		            
		            if(field.getType().equals(java.lang.String.class))
		            	field.set(obj, "");
		            	
		            if(!access) field.setAccessible(false);
		            	        
		        }  
	        	catch(java.lang.IllegalArgumentException ee){
	        		
	        	}
		        catch (Exception ex)  
		        {  
		            ex.printStackTrace();  
		        } 
	        }
	    }
	}
	
	public static void filterList(List objs,List<String> resverseFs){
		for(Object o : objs){
			FieldUtil.filter(o, resverseFs);
		}
	}
}
