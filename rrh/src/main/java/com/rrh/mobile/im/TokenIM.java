package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.respoint.TokenRespoint;
import com.rrh.mobile.im.util.HttpUtil;

public class TokenIM {
	
	// 获取token
	public static TokenRespoint getToken(int userId, String userName, String portraitUri) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GET_TOKEN);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId+"");
		paramsMap.put("name", userName==null?"":userName);
		paramsMap.put("portraitUri", portraitUri==null?"":portraitUri);
		HttpUtil.setBodyParameter(paramsMap, conn);
		SdkHttpResult result=HttpUtil.returnResult(conn);
		return (TokenRespoint)result.getBean(TokenRespoint.class);
	}
}
