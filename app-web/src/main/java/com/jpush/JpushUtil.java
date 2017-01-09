package com.jpush;

import com.thoughtworks.xstream.XStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import cn.jpush.api.*;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * User: rizenguo
 * Date: 2014/10/23
 * Time: 14:59
 */
public class JpushUtil{

	
    //打log用
	private static Logger logger = LoggerFactory.getLogger(JpushUtil.class);
	
	//http://docs.jiguang.cn/server/java_sdk/
	public static void pushInfo(String masterSecret, String appKey, int maxRetryTimes, String platform,
			java.util.List<String> registerIds, String mainMessage, java.util.Map<String,String> extraMap){
		
		ClientConfig  cc = ClientConfig.getInstance();
		cc.put(ClientConfig.MAX_RETRY_TIMES, maxRetryTimes);
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, cc);
		
		Audience.Builder ab = Audience.newBuilder();
		Audience aud = null;
		if(registerIds!=null && !registerIds.isEmpty()){
			ab.addAudienceTarget(AudienceTarget.registrationId(registerIds));
			aud = ab.build();
		}
		else{
			aud = Audience.all();	
		}
		
		Platform pf = null;
		if(platform.toLowerCase().equals("ios"))
			pf = Platform.ios();
		if(platform.toLowerCase().equals("aos"))
			pf = Platform.android();
		if(pf == null)
			pf = Platform.all();
		
		Message.Builder mb = Message.newBuilder();
		if(extraMap != null && !extraMap.isEmpty()){
			mb.addExtras(extraMap);
		}
		mb.setMsgContent(mainMessage);
		
		Notification nf = null;
		if(platform.toLowerCase().equals("aos"))
			nf = Notification.android(mainMessage, "", extraMap);
		if(platform.toLowerCase().equals("ios"))
			nf = Notification.ios(mainMessage, extraMap);
		if(nf == null)
			nf = Notification.alert(mainMessage);
		
		
		PushPayload payload = PushPayload.newBuilder()
				.setPlatform(pf)
				.setAudience(aud)
				.setNotification(nf)
				//.setMessage(mb.build())
				.build();
		
        // For push, all you need do is to build PushPayload object.
        

        try {
            PushResult result = jpushClient.sendPush(payload);
            logger.info("Got result - " + result);
            logger.info("is result ok?"+ result.isResultOK());

        } catch (APIConnectionException e) {
            // Connection error, should retry later
        	logger.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
        	logger.error("Should review the error, and fix the request", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());
        }
	}
	
}
