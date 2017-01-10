package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;



/**
 *  DateUtil.java
 *  Description:
 *  
 *  CreateDate: 2015年12月13日 上午10:14:48 
 * 
 *  @author 李嘉琳
 */
public class DateUtil {

	public static String createWifipOrderSeriesNumber(){
		String sOut = DateToString(new Date(),"yyMMdd");
		String sSeeds ="0123456789abcdefghijklmnopqrttuvwxyz";
		for(int i=0;i<4;i++){
			int sIndex = (int)Math.round(Math.random() * 35);
			String sVal = sSeeds.substring(sIndex,sIndex+1);
			sOut = sOut + sVal;
		}
		return  sOut;
	}

	public static String createOrderSeriesNumber(){
		String sOut = DateToString(new Date(),"yyMMdd");
		String sSeeds ="0123456789abcdefghijklmnopqrttuvwxyz";
		for(int i=0;i<4;i++){
			int sIndex = (int)Math.round(Math.random() * 35);
			String sVal = sSeeds.substring(sIndex,sIndex+1);
			sOut = sOut + sVal;
		}
	    System.out.println("order series_number:"+sOut);
		return sOut;
	}
	/** 
     * 将日期转化为日期字符串。失败返回null。 格式 yyyy-MM-dd
     * @param date 日期 
     * @param pattern 日期格式 
     * @return 日期字符串 
     */  
	public static String DateToStringM(Date date) {  
        return DateToString(date,"yyyy-MM-dd HH:mm");  
   } 
	 public static String DateToStringSecond(Date date) {  
	        return DateToString(date,"yyyy-MM-dd HH:mm:ss");  
	   } 
	 
    public static String DateToString(Date date) {  
        return DateToString(date,"yyyy-MM-dd");  
    } 
    
    public static String DateToStringMonth(Date date) {  
        return DateToString(date,"yyyy-MM");  
    } 
    
    public static String DateToStringHour(Date date) {  
        return DateToString(date,"yyyy-MM-dd HH");  
    } 
	/** 
     * 将日期字符串转化为日期。失败返回null。 格式 yyyy-MM-dd
     * @param date 日期字符串 
     * @param pattern 日期格式 
     * @return 日期 
     */  
    public static Date StringToDate(String date) {  
        return StringToDate(date,"yyyy-MM-dd");  
    } 
    public static Date StringToDateMonth(String date) {  
        return StringToDate(date,"yyyy-MM");  
    }
    public static Date StringToDateMinute(String date) {
            return StringToDate(date,"yyyy-MM-dd HH:mm");
        }
	/** 
     * 将日期转化为日期字符串。失败返回null。 
     * @param date 日期 
     * @param pattern 日期格式 
     * @return 日期字符串 
     */  
    public static String DateToString(Date date, String pattern) {  
        String dateString = null;  
        if (date != null) {  
            try {  
            	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            	dateString = sdf.format(date); 
            } catch (Exception e) {
            	System.out.println(date.toString()+"：日期转化错误");
            }  
        }  
        return dateString;  
    }  
    
    /** 
     * 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @param pattern 日期格式 
     * @return 日期 
     */  
    public static Date StringToDate(String date, String pattern) {  
        Date myDate = null;  
        if (date != null) {  
            try {  
            	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            	myDate = sdf.parse(date);
            } catch (Exception e) {
            	System.out.println(date.toString()+"：日期转化错误");
            }  
        }  
        return myDate;  
    }  
	 /** 
     * 增加日期的天数。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加天数后的日期 
     */  
    public static Date addDay(Date date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }
    
    public static Date addMinute(Date date, int dayAmount) {  
        return addInteger(date, Calendar.MINUTE, dayAmount);  
    }
    
    /**
     * 返回两个yyyy-MM-dd格式的日期之间的日期组成的字符串数组，
     * 例如："2015-9-29","2015-10-02"，返回
     * [2015-09-29, 2015-09-30, 2015-10-01, 2015-10-02]
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public static String[] getDateStringArray(String dateFrom,String dateTo){
    	String[] dateArray = new String[daysBetween(dateFrom, dateTo)];
    	Date from = StringToDate(dateFrom);
    	Date to = StringToDate(dateTo);
    	int i = 0;
    	while(from.getTime()<=to.getTime()){
    		dateArray[i++] = DateToString(from);
    		from = addDay(from, 1);
    	}
    	return dateArray;
    }
    
    /**
	 * 计算两个日期之间相差的天数,包含起始日期
	 * @param smdate	较小的时间
	 * @param bdate		较大的时间
	 * @return 			相差天数，返回负值表示smdate大于bdate，返回0表示日期格式转换有误
	 */
	public static int daysBetween(Date smdate, Date bdate){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			
			if(between_days>=0){
				return Integer.parseInt(String.valueOf(between_days))+1;
			}else{
				return Integer.parseInt(String.valueOf(between_days))-1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 计算两个yyyy-MM-dd格式的日期之间的天数,包含起始日期
	 * @param smdate	较小的时间
	 * @param bdate		较大的时间
	 * @return			相差天数，返回负值表示smdate大于bdate，返回0表示日期格式转换有误
	 */
	public static int daysBetween(String smdate, String bdate){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			
			if(between_days>=0){
				return Integer.parseInt(String.valueOf(between_days))+1;
			}else{
				return Integer.parseInt(String.valueOf(between_days))-1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
    
    /** 
     * 增加日期中某类型的某数值。如增加日期  
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    private static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  
    public static int getDateIntValue(String date){
    	Long from = DateUtil.StringToDate(date).getTime()/1000;
    	return from.intValue();
    }
    
    public static int getDateIntValue(Date date){
    	Long from = date.getTime()/1000;
    	return from.intValue();
    }
    
    public static String secToTime(int time) {  
        String timeStr = null;  
        int hour = 0;  
        int minute = 0;  
        int second = 0;  
        if (time <= 0)  
            return "00:00";  
        else {  
            minute = time / 60;  
            if (minute < 60) {  
                second = time % 60;  
                timeStr = unitFormat(minute) + ":" + unitFormat(second);  
            } else {  
                hour = minute / 60;  
                if (hour > 99)  
                    return "99:59:59";  
                minute = minute % 60;  
                second = time - hour * 3600 - minute * 60;  
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);  
            }  
        }  
        return timeStr;  
    } 
    public static String unitFormat(int i) {  
        String retStr = null;  
        if (i >= 0 && i < 10)  
            retStr = "0" + Integer.toString(i);  
        else  
            retStr = "" + i;  
        return retStr;  
    }
    /**
     * 返回当前时间, yyyy-MM-dd
     * @return
     */
    public static Date getNow(){
    	 Calendar calendar = Calendar.getInstance();
    	 Date date = calendar.getTime();
    	 return DateUtil.StringToDate(DateUtil.DateToString(date,"yyyy-MM-dd"),"yyyy-MM-dd");
    }
    
    /**
     * 返回当前时间
     * 时间格式 pattern
     * @param pattern
     * @return
     */
    public static Date getNow(String pattern){
   	 Calendar calendar = Calendar.getInstance();
   	 Date date = calendar.getTime();
   	 return DateUtil.StringToDate(DateUtil.DateToString(date,pattern),pattern);
   }
    public static void main(String[] args){
    	System.out.println(secToTime(155));
    	System.out.println(Arrays.toString(getDateStringArray("2015-10-02","2015-10-02")));
    }
    
    public static class Age
    {
       private int days;
       private int months;
       private int years;
     
       private Age()
       {
          //Prevent default constructor
       }
     
       public Age(int days, int months, int years)
       {
          this.days = days;
          this.months = months;
          this.years = years;
       }
     
       public int getDays()
       {
          return this.days;
       }
     
       public int getMonths()
       {
          return this.months;
       }
     
       public int getYears()
       {
          return this.years;
       }
     
       @Override
       public String toString()
       {
    	   if(years == -1)
    		   return "未设定";
    	   else
    		   return years + "岁" + months + "个月";// + days + " Days";
       }
    }
    
    public static Age calculateAge(Date birthDate)
    {
    	if(birthDate == null)
    		return new Age(0,0,0);
    	
       int years = 0;
       int months = 0;
       int days = 0;
       //create calendar object for birth day
       Calendar birthDay = Calendar.getInstance();
       birthDay.setTimeInMillis(birthDate.getTime());
       //create calendar object for current day
       long currentTime = System.currentTimeMillis();
       Calendar now = Calendar.getInstance();
       now.setTimeInMillis(currentTime);
       //Get difference between years
       years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
       int currMonth = now.get(Calendar.MONTH) + 1;
       int birthMonth = birthDay.get(Calendar.MONTH) + 1;
       //Get difference between months
       months = currMonth - birthMonth;
       //if month difference is in negative then reduce years by one and calculate the number of months.
       if (months < 0)
       {
          years--;
          months = 12 - birthMonth + currMonth;
          if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
             months--;
       } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
       {
          years--;
          months = 11;
       }
       //Calculate the days
       if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
          days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
       else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
       {
          int today = now.get(Calendar.DAY_OF_MONTH);
          now.add(Calendar.MONTH, -1);
          days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
       } else
       {
          days = 0;
          if (months == 12)
          {
             years++;
             months = 0;
          }
       }
       //Create new Age object 
       return new Age(days, months, years);
    }

}
