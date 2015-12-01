package com.rrh.common;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SourceManager {

	@Value("#{configProperties['local.root']}")
	private String localRoot;
	@Value("#{configProperties['network.root']}")
	private String networkRoot;
	@Value("#{configProperties['user_resources_path']}")
	private String userResourcesPath;
	@Value("#{configProperties['business_resources_path']}")
	private String businessResourcesPath;
	@Value("#{configProperties['group_resources_path']}")
	private String groupResourcesPath;
	@Value("#{configProperties['user_pic_path']}")
	private String userPicPath;
	@Value("#{configProperties['business_pic_path']}")
	private String businessPicPath;
	@Value("#{configProperties['group_pic_path']}")
	private String groupPicPath;
	
	public String getUserResourcesFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + userResourcesPath + (isLocal ? File.separator : "/");
	}
	
	public String getBusinessResourcesFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + businessResourcesPath + (isLocal ? File.separator : "/");
	}
	
	public String getGroupResourcesFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + groupResourcesPath + (isLocal ? File.separator : "/");
	}
	
	public String getUserPicFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + userPicPath + (isLocal ? File.separator : "/");
	}
	
	public String getBusinessPicFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + businessPicPath + (isLocal ? File.separator : "/");
	}
	
	public String getGroupPicFolderPath(boolean isLocal){
		return (isLocal ? localRoot : networkRoot) + groupPicPath + (isLocal ? File.separator : "/");
	}
}
