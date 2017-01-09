package util;


public class Random {
	public static String generateWithCharNumber(int width){
		return ValidateCode.generateTextCode(4,width,null);
	}
};
