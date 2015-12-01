package com.rrh.jpush;

import java.sql.Timestamp;
import java.util.HashMap;

import cn.jpush.api.push.model.PushPayload;

public interface IJpushWrapper{	
	/**
	 * 推送给所有人
	 * @param msgContent
	 * @return
	 */
	public boolean pushToAll(String msgContent, Timestamp pushDate);
	
	/**
	 * 根据用户Id集合推送
	 * @param msgContent
	 * @param personIds
	 * @return
	 */
	public boolean pushByIds(String msgContent, String[] personIds, Timestamp pushDate,HashMap<String,String> map);
	
	/**
	 * 根据组织Id集合推送
	 * @param msgContent
	 * @param orgs
	 * @return
	 */
	public boolean pushByOrgs(String msgContent, String[] orgs, Timestamp pushDate);
	
	/**
	 * 推送，返回是否成功
	 * @param pushPayload
	 * @return
	 */
	public boolean sendPush(PushPayload pushPayload, Timestamp pushDate);
	
	public void initClient();
}
