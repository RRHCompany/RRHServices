package com.rrh.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rrh.base.BaseResponse;
import com.rrh.common.ErrorMsgConstant;
import com.rrh.common.SystemConstant;

@ControllerAdvice
@Lazy
public class ExceptionHandler {
	protected final Logger log = Logger.getLogger(getClass().getName());

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response){
		log.error("全局异常捕获==============>start");
		log.error("", e);
		JSONObject errorJson = (JSONObject) JSON.toJSON(new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME));
		try {
			com.rrh.common.CommonUtils.sendJson((HttpServletResponse) response, errorJson);
		} catch (IOException e1) {
			log.error("", e1);
		}
		log.error("全局异常捕获==============>end");
	}
}
