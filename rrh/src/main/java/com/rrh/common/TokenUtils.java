package com.rrh.common;

public class TokenUtils {

	/**
	 * 根据用户Id获取token
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static String getTokenByUserId(Integer userId) throws Exception{
		return Coder.encryptBASE64(Coder.encryptBASE64(userId.toString().getBytes()).trim().getBytes()).trim();
	}
	
	public static String getUserIdByToken(String token) throws Exception{
		return new String(Coder.decryptBASE64(new String(Coder.decryptBASE64(token))));
	}
}
