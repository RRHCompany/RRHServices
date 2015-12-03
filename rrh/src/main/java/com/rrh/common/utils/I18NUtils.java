package com.rrh.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * 国际化
 * */
public class I18NUtils {

//	private static RequestContext requestContext;
//	
//	public static String getString(HttpServletRequest request,String tag){
//		if(requestContext==null){
//			requestContext = new RequestContext(request);
//		}
//        return requestContext.getMessage(tag);
//	}
	//暂时使用文件读取方式，未实现国际化
	private static I18NUtils instaner;
	
	private Properties prop=null;
	
	private I18NUtils(){
		try {
			prop=new Properties();
			prop.load(new InputStreamReader(I18NUtils.class.getClassLoader().getResourceAsStream("/i18n_msg.properties"), "UTF-8")); 
//			InputStream is=this.getClass().getResourceAsStream("/i18n_msg.properties");  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static I18NUtils getInstaner(){
//		if(instaner==null){
			instaner=new I18NUtils();//测试使用，不做判断
//		}
		return instaner;
	}
	
	public String getMessage(String key){
		return prop.getProperty(key);
	}
}
