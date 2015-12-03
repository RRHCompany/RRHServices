package com.rrh.common.utils;

import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 基础加密组件
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class Coder {
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";
	
	private static final String encoding = "UTF-8";
	private final static String iv = "01234567";  
	private static final String encryptKey = "cn.com.xiadanlacmmanager_@_123_456";

	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 * HmacMD5 
	 * HmacSHA1 
	 * HmacSHA256 
	 * HmacSHA384 
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);

		return sha.digest();

	}

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}
	
	/** 
     * 加密字符串 
     */  
    public static String encryptDES(String str) { 
    	try{
    		 Key deskey = null;  
             DESedeKeySpec spec = new DESedeKeySpec(encryptKey.getBytes());  
             SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
             deskey = keyfactory.generateSecret(spec);  
       
             Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
             IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
             cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);  
             byte[] encryptData = cipher.doFinal(str.getBytes(encoding));  
             return encryptBASE64(encryptData);
    	}catch(Exception e){
    		e.fillInStackTrace();
    		return null;
    	}
    }  
  
    /** 
     * 解密字符串 
     */  
    public static String decryptDES(String str) { 
    	try{
    		Key deskey = null;  
	         DESedeKeySpec spec = new DESedeKeySpec(encryptKey.getBytes());  
	         SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
	         deskey = keyfactory.generateSecret(spec);  
	         Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
	         IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
	         cipher.init(Cipher.DECRYPT_MODE, deskey, ips);  	   
	         byte[] decryptData = cipher.doFinal(decryptBASE64(str));	   
	         return new String(decryptData, encoding); 
    	}catch(Exception e){
    		e.fillInStackTrace();
    		return null;
    	}
    }  
}
