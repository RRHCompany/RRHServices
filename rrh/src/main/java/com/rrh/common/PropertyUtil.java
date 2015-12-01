package com.rrh.common;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * 获取系统gfconfig-property属性服务类
 * 
 * @author lele
 * 
 */   
public class PropertyUtil {
	private static PropertyUtil instance = new PropertyUtil();
	private static Properties properties;
	private PropertyUtil() {
	}
	//资源服务器的地址
	public String getServerURI() {
		return this.getProperty("host_uri");
	}
	//系统资源储存路径
	public String getSysResources() {
		return this.getProperty("sys_resources_path");
	}
	//系统资源储存路径
	public String getUserResources() {
		return this.getProperty("user_resources_path");
	}
	//图片资源储存路径
	public String getPicPart(){
		return this.getProperty("pic_path");
	}
	//用户头像的标准大小 压缩标准
	public String getHeadPicSize(){
		return this.getProperty("head_pic_size");
	}
	//资源图片的标准大小 压缩标准
	public String getResourcesPicPart(){
		return this.getProperty("resources_pic_size");
	}
	//获取推送KEY
	public String getJpushKey(){
		return this.getProperty("jpush_key");
	}
	//获取推Master
	public String getJpushMaster(){
		return this.getProperty("jpush_master");
	}
	public static PropertyUtil getInstance() {
		return instance;
	}
 
	public String getProperty(String key) {
		if (properties == null || properties.size() == 0) {
		   properties = new Properties();
		   try {
			    properties.load(this.getClass().getResourceAsStream(
			      "/config.properties"));//配置文件所在的位置，一定要在根目录下面
		   } catch (FileNotFoundException e) {
			   //writeLogBiz.writes(e, this.getClass(), "未找到配置文件config.properties");
		   } catch (IOException e) {
			   //writeLogBiz.writes(e, this.getClass(),"读取配置文件config.properties出现异常");
		   } catch (Exception e) {
			   //writeLogBiz.writes(e, this.getClass(),"装载配置文件config.properties出现异常");
		   }
	  }
		return properties.getProperty(key);
	} 
	
	
 public static void main(String args[]){
	 String name = PropertyUtil.getInstance().getServerURI();
	 System.out.println(name);
 }
}
