package com.dos.bsapp.service;



import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.dos.bsapp.model.VUnit;
import com.jpush.JPushConfig;

@Service("JPushService")
public class JPushService  extends ComService
{
	public static class JPushData
	{
		private String message;
		private String platform;
		public String getPlatform() {
			return platform;
		}
		public void setPlatform(String platform) {
			this.platform = platform;
		}
		private List<String> registerId;
		private Map<String,String> extra;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public List<String> getRegisterId() {
			return registerId;
		}
		public void setRegisterId(List<String> registerId) {
			this.registerId = registerId;
		}
		public Map<String, String> getExtra() {
			return extra;
		}
		public void setExtra(Map<String, String> extra) {
			this.extra = extra;
		}
	};
    public void act(String unitSeriesNumber,
    		String data,
    		String sign) throws Exception
    {
        VUnit vunit = checkIfStatus(unitSeriesNumber,"", data,sign);
        JPushConfig	jpushConfig = (JPushConfig)util.JsonUtil.parseString(vunit.getSetting(), JPushConfig.class);
        JPushData jpushData = (JPushData)util.JsonUtil.parseString(data, JPushData.class);
        com.jpush.JpushUtil.pushInfo(
        		jpushConfig.getMasterSecret(),
        		jpushConfig.getAppKey(),
        		jpushConfig.getMaxRetryTimes(),
        		jpushData.getPlatform(),
        		jpushData.getRegisterId(),
        		jpushData.getMessage(),
        		jpushData.getExtra()
        		);
    }


}
