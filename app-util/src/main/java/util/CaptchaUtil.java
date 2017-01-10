package util;

import java.util.HashMap;
import java.util.Map;

public class CaptchaUtil {
	
	private static Map<String, String> CAPTCHA_MAP = new HashMap<String, String>();
	
	public static String pushCaptcha(String mobile) {
		int captcha = CaptchaUtil.genCaptcha();
		//System.out.println("push mobileCode:" + String.valueOf(captcha));
		CAPTCHA_MAP.put(mobile, String.valueOf(captcha));
		return String.valueOf(captcha);
	}
	
	public static String popCaptcha(String mobile) {
		String captcha = CAPTCHA_MAP.get(mobile);
		CAPTCHA_MAP.remove(mobile);
		//System.out.println("pop mobileCode:" + mobile + " : " + String.valueOf(captcha));
		return captcha;
	}
	
	public static String pushCaptcha(String mobile, String captcha) {
		//System.out.println("push mobileCode:" + String.valueOf(captcha));
		CAPTCHA_MAP.put(mobile, String.valueOf(captcha));
		return String.valueOf(captcha);
	}
	
	public static int genCaptcha() {
		int captcha = (int)((Math.random()*9+1)*100000);
		return captcha;
	}
	
}
