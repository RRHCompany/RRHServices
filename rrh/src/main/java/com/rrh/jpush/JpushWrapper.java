package com.rrh.jpush;

import java.sql.Timestamp;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;



@Service
public class JpushWrapper implements IJpushWrapper{
	static Logger logger = Logger.getLogger(JpushWrapper.class.getName());
	@Value("#{configProperties['jpush_key']}")
	private String jpushKey;
	@Value("#{configProperties['jpush_master']}")
	private String jpushMaster;
	private JPushClient client;
	
	/**
	 * 推送给所有人
	 * @param msgContent
	 * @return
	 */
	public boolean pushToAll(String msgContent, Timestamp pushDate){
		PushPayload payload = PushPayload.alertAll(msgContent);
		return sendPush(payload, pushDate);
	}
	
	/**
	 * 根据用户Id集合推送
	 * @param msgContent
	 * @param personIds
	 * @return
	 */
	public boolean pushByIds(String msgContent, String[] personIds, Timestamp pushDate, HashMap<String,String> map){
		PushPayload pushPayload = PushPayload.newBuilder()
									.setPlatform(Platform.all())
									.setAudience(Audience.alias(personIds))
									.setNotification(Notification.alert(msgContent))
									.setMessage(Message.newBuilder()
					                        .setMsgContent(msgContent)
					                        .addExtras(map)
					                        .build()).build();
		return sendPush(pushPayload, pushDate);
	}
	
	/**
	 * 根据组织Id集合推送
	 * @param msgContent
	 * @param orgs
	 * @return
	 */
	public boolean pushByOrgs(String msgContent, String[] orgs, Timestamp pushDate){
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.tag(orgs))
				.setNotification(Notification.alert(msgContent)).build();
		return sendPush(pushPayload, pushDate);
	}
	
	/**
	 * 推送，返回是否成功
	 * @param pushPayload
	 * @return
	 */
	public boolean sendPush(PushPayload pushPayload, Timestamp pushDate){
		boolean isSuccess = false;
		try {
			initClient();
			logger.info("推送任务开始");
			isSuccess = client.sendPush(pushPayload).isResultOK();
			logger.info("推送任务完成");
		} catch (APIConnectionException e) {
			logger.error("", e);
		} catch (APIRequestException e) {
			logger.error("", e);
		} catch (Exception e){
			logger.error("", e);
		}
		return isSuccess;
	}
	
	public void initClient(){
		if(client == null)
			client = new JPushClient(jpushMaster, jpushKey);
	}
}
