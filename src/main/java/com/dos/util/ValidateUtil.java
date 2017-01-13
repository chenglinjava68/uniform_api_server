package com.dos.util;

import com.dos.exception.PostParamException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {	
	public static boolean checkEnglishCharactor(String val){
		if(null == val) {
			return false;
		}
		//task8 正则表达式，监测val中都是英文，都是英文返回true，否则返回false
		boolean flag = false;
        try{
            String check = "^[a-zA-Z]+$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(val);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
	}
	public static boolean checkChineseCharactor(String val){
		if(null == val) {
			return false;
		}
		//task8 正则表达式，监测val中都是中文，都是中文返回true，否则返回false
		boolean flag = false;
		try{
			String check = "^[\u4e00-\u9fa5]+$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(val);
			flag = matcher.matches();
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}
	public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
	
	public static boolean checkMobileNumber(String mobileNumber){
        boolean flag = true;
        try{
                Pattern regex = Pattern.compile("^1\\d{10}$");
                Matcher matcher = regex.matcher(mobileNumber);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
	
	public static boolean checkMinMaxLength(String val, int min, int max){
		boolean flag = true;
		if(val == null && min == 0){
			flag = true;
		}			
		else{
			int valLength = val.length();
			if(valLength < min || valLength > max)
				flag = false;
		}
		return flag;
	}
	
	public static boolean checkGender(String val){
		return ("female".equals(val) || "male".equals(val));		
	}
	
	protected static String [] provinceList = {"黑龙江","辽宁","吉林","内蒙古","新疆","北京","天津","河北","山东","山西","陕西","宁夏","甘肃","青海","西藏","江苏","上海","安徽","河南","湖北","重庆","四川","浙江","福建","湖南","贵州","广东","广西","云南","香港","澳门","台湾","海南"};
	protected static String [] province2List = {"北京","上海","广州","深圳","杭州","武汉","成都","南京","天津","重庆","福州","黑龙江","辽宁","吉林","内蒙古","新疆","河北","山东","山西","陕西","宁夏","甘肃","青海","西藏","江苏","安徽","河南","湖北","重庆","四川","浙江","福建","湖南","贵州","广东","广西","云南","香港","澳门","台湾","海南"};
	protected static List<String[]>  cityList = null;
	protected static String[] 	sToAdd1 = {"齐齐哈尔市","哈尔滨市","大庆市","佳木斯市","双鸭山市","牡丹江市","鸡西市","黑河市","绥化市","鹤岗市","伊春市","大兴安岭地区","七台河市"};
	protected static String[] 	sToAdd2 = {"大连市","沈阳市","丹东市","辽阳市","葫芦岛市","锦州市","朝阳市","营口市","鞍山市","抚顺市","阜新市","盘锦市","本溪市","铁岭市"};
	protected static String[] 	sToAdd3 = {"吉林市","长春市","白山市","延边州","白城市","松原市","辽源市","通化市","四平市"};
	protected static String[] 	sToAdd4 = {"赤峰市","包头市","通辽市","呼和浩特市","鄂尔多斯市","乌海市","呼伦贝尔市","兴安盟","巴彦淖尔盟","乌兰察布盟","锡林郭勒盟","阿拉善盟"};
	protected static String[] 	sToAdd5 = {"乌鲁木齐市","伊犁州","昌吉州","石河子市","哈密地区","阿克苏地区","巴音郭楞州","喀什地区","塔城地区","克拉玛依市","和田地区","阿勒泰州","吐鲁番地区","阿拉尔市","博尔塔拉州","五家渠市","克孜勒苏州","图木舒克市"};
	protected static String[] 	sToAdd6 = {"北京"};
	protected static String[] 	sToAdd7 = {"天津"};
	protected static String[] 	sToAdd8 = {"石家庄市","唐山市","保定市","邯郸市","邢台市","河北区","沧州市","秦皇岛市","张家口市","衡水市","廊坊市","承德市"};
	protected static String[] 	sToAdd9 = {"济南市","青岛市","临沂市","济宁市","菏泽市","烟台市","淄博市","泰安市","潍坊市","日照市","威海市","滨州市","东营市","聊城市","德州市","莱芜市","枣庄市"};
	protected static String[] 	sToAdd10 = {"太原市","大同市","运城市","长治市","晋城市","忻州市","临汾市","吕梁市","晋中市","阳泉市","朔州市"};
	protected static String[] 	sToAdd11 = {"西安市","咸阳市","宝鸡市","汉中市","渭南市","安康市","榆林市","商洛市","延安市","铜川市"};
	protected static String[] 	sToAdd12 = {"银川市","吴忠市","中卫市","石嘴山市","固原市"};
	protected static String[] 	sToAdd13 = {"兰州市","天水市","庆阳市","武威市","酒泉市","张掖市","陇南地区","白银市","定西地区","平凉市","嘉峪关市","临夏回族自治州","金昌市","甘南州"};
	protected static String[] 	sToAdd14 = {"西宁市","海西州","海东地区","海北州","果洛州","玉树州","黄南藏族自治州"};
	protected static String[] 	sToAdd15 = {"拉萨市","山南地区","林芝地区","日喀则地区","阿里地区","昌都地区","那曲地区"};
	protected static String[] 	sToAdd16 = {"苏州市","徐州市","盐城市","无锡市","南京市","南通市","连云港市","常州市","镇江市","扬州市","淮安市","泰州市","宿迁市"};
	protected static String[] 	sToAdd17 = {"上海"};
	protected static String[] 	sToAdd18 = {"芜湖市","合肥市","六安市","宿州市","阜阳市","安庆市","马鞍山市","蚌埠市","淮北市","淮南市","宣城市","黄山市","铜陵市","亳州市","池州市","巢湖市","滁州市"};
	protected static String[] 	sToAdd19 = {"郑州市","南阳市","新乡市","安阳市","洛阳市","信阳市","平顶山市","周口市","商丘市","开封市","焦作市"," 驻马店市","濮阳市","三门峡市","漯河市","许昌市","鹤壁市","济源市"};
	protected static String[] 	sToAdd20 = {"武汉市","宜昌市","襄樊市","荆州市","恩施州","黄冈市","孝感市","十堰市","咸宁市","黄石市","仙桃市","天门市","随州市","荆门市","潜江市","鄂州市","神农架林区"};
	protected static String[] 	sToAdd21 = {"重庆"};
	protected static String[] 	sToAdd22 = {"成都市","绵阳市","广元市","达州市","南充市","德阳市","广安市","阿坝州","巴中市","遂宁市","内江市","凉山州","攀枝花市","乐山市","自贡市","泸州市","雅安市","宜宾市","资阳市","眉山市","甘孜州"};
	protected static String[] 	sToAdd23 = {"温州市","宁波市","杭州市","台州市","嘉兴市","金华市","湖州市","绍兴市","舟山市","丽水市","衢州市"};
	protected static String[] 	sToAdd24 = {"漳州市","厦门市","泉州市","福州市","莆田市","宁德市","三明市","南平市","龙岩市"};
	protected static String[] 	sToAdd25 = {"长沙市","邵阳市","常德市","衡阳市","株洲市","湘潭市","永州市","岳阳市","怀化市","郴州市","娄底市","益阳市","张家界市","湘西州"};
	protected static String[] 	sToAdd26 = {"贵阳市","黔东南州","黔南州","遵义市","黔西南州","毕节地区","铜仁地区","安顺市","六盘水市"};
	protected static String[] 	sToAdd27 = {"东莞市","广州市","中山市","深圳市","惠州市","江门市","珠海市","汕头市","佛山市","湛江市","河源市","肇庆市","清远市","潮州市","韶关市","揭阳市","阳江市","梅州市","云浮市","茂名市","汕尾市"};
	protected static String[] 	sToAdd28 = {"贵港市","玉林市","北海市","南宁市","柳州市","桂林市","梧州市","钦州市","来宾市","河池市","百色市","贺州市","崇左市","防城港市"};
	protected static String[] 	sToAdd29 = {"昆明市","红河州","大理州","文山州","德宏州","曲靖市","昭通市","楚雄州","保山市","玉溪市","丽江地区","临沧地区","思茅地区","西双版纳州","怒江州","迪庆州"};
	protected static String[] 	sToAdd30 = {"香港特别行政区"};
	protected static String[] 	sToAdd31 = {"澳门特别行政区"};
	protected static String[] 	sToAdd32 = {"台北市","高雄市","台中市","新竹市","基隆市","台南市","嘉义市"};
	protected static String[] 	sToAdd33 = {"三亚市","海口市","琼海市","文昌市","东方市","昌江县","陵水县","乐东县","保亭县","五指山市","澄迈县","万宁市","儋州市","临高县","白沙县","定安县","琼中县","屯昌县"};
	protected static void initCityList(){
		if(ValidateUtil.cityList==null){
			ValidateUtil.cityList = new java.util.ArrayList<String[]>();
			//task1 add from sToAdd1 to sToAdd33
			cityList.add(sToAdd1);
			cityList.add(sToAdd2);
			cityList.add(sToAdd3);
			cityList.add(sToAdd4);
			cityList.add(sToAdd5);
			cityList.add(sToAdd6);
			cityList.add(sToAdd7);
			cityList.add(sToAdd8);
			cityList.add(sToAdd9);
			cityList.add(sToAdd10);
			cityList.add(sToAdd11);
			cityList.add(sToAdd12);
			cityList.add(sToAdd13);
			cityList.add(sToAdd14);
			cityList.add(sToAdd15);
			cityList.add(sToAdd16);
			cityList.add(sToAdd17);
			cityList.add(sToAdd18);
			cityList.add(sToAdd19);
			cityList.add(sToAdd20);
			cityList.add(sToAdd21);
			cityList.add(sToAdd22);
			cityList.add(sToAdd23);
			cityList.add(sToAdd24);
			cityList.add(sToAdd25);
			cityList.add(sToAdd26);
			cityList.add(sToAdd27);
			cityList.add(sToAdd28);
			cityList.add(sToAdd29);
			cityList.add(sToAdd30);
			cityList.add(sToAdd31);
		}
	}
	public static boolean checkAddressProvince(String val){		
		if(val == null)
			return false; 
		for(int i = 0; i< ValidateUtil.provinceList.length; i++){
			if( ValidateUtil.provinceList[i].equals(val) )
				return true;
		}
		return false;
	}

	public static boolean checkAddressProvince2(String val){
    		if(val == null)
    			return false;
    		String[] sStore = ValidateUtil.province2List;
    		for(int i=0;i<sStore.length;i++){
    			if( sStore[i].equals(val) )
    				return true;
    		}
    		return false;
    	}


	
	//正常输入   province="北京" city="北京"  应该return true;
	//异常输入   province="北京" city="上海"  应该return false;
	public static boolean checkAddressCity(String province, String city){
		//if province is null or city is null,return false.
		if(province == null || city == null)
			return false;
		
		//判断省份列表是否包含传入的省份名称
		List<String> provinceLists = Arrays.asList(provinceList);
		if(!provinceLists.contains(province)){
			return false;
		}
		
		//init the cityMap
		ValidateUtil.initCityList();
		
		//获得入参省份对应的城市集合
		List<String> sToAdds = Arrays.asList(cityList.get(provinceLists.indexOf(province)));
		if(sToAdds.contains(city)){
			return true;
		}
		return false;
	}
	
	//idcardNumber:  身份证号码， 如果格式正确，那么返回出生日期格式为： 19820504
	public static String checkIdCardNumber(String idCardNumber) throws Exception{
		String birthday = "";
		Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");  
		if(!idNumPattern.matcher(idCardNumber).matches()){
			throw new PostParamException("身份证格式数据错误");
		}
		
		int year = Integer.valueOf(idCardNumber.substring(6, 10));
		int month = Integer.valueOf(idCardNumber.substring(10,12));
		int day = Integer.valueOf(idCardNumber.substring(12,14));
		if(year>1900 && year<2100 
				&& month>=1 && month<=12
				&& day>=1 && day<=31){
			birthday = idCardNumber.substring(6, 14);
		}else{
			throw new PostParamException("出生年月日数据错误");
		}
		
		if(birthday==null || birthday.length() == 0){
			throw new PostParamException("出生年月日数据错误");
		}
		return birthday;
	}
	
	//GXXXXXXXX
	public static boolean checkPassportNumber(String val){
		if(null == val) {
			return false;
		}
		//task7 正则表达式   ^1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|D[0-9]+$   参考
		boolean flag = false;
        try{
            String check = "^1[45][0-9]{7}|[EG][0-9]{8}|P[0-9]{7,8}|S[0-9]{7,8}|D[0-9]+$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(val);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
	}
	
}
