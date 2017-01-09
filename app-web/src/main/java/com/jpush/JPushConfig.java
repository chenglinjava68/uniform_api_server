package com.jpush;

public class JPushConfig {
	private String masterSecret = "";
	private String appKey = "";
	private int maxRetryTimes = 5;
	public String getMasterSecret() {
		return masterSecret;
	}
	public void setMasterSecret(String masterSecret) {
		this.masterSecret = masterSecret;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public int getMaxRetryTimes() {
		return maxRetryTimes;
	}
	public void setMaxRetryTimes(int maxRetryTimes) {
		this.maxRetryTimes = maxRetryTimes;
	}
}
