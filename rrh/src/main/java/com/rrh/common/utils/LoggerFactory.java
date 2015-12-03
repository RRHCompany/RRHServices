package com.rrh.common.utils;

import org.apache.log4j.Logger;

import com.rrh.base.BaseService;

/**
 * 日记打印类
 * @author jason
 * @data 2015-12-3
 */
public class LoggerFactory {

	private boolean DEBUG=true;//是否打印日记
	
	private Logger log = Logger.getLogger(BaseService.class.getName());
	
	private static LoggerFactory instaner;
	private LoggerFactory(){
		
	}
	public static LoggerFactory getInstaner(){
		if(instaner==null){
			instaner=new LoggerFactory();
		}
		return instaner;
	}
	public void error(Object message){
		this.error(message, null);
	}
	public void error(Throwable error){
		this.error("", error);
	}
	public void error(Object message,Throwable error){
		if(DEBUG){
			log.error(message, error);
		}
	}
}
