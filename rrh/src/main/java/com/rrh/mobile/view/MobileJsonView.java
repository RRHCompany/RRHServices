package com.rrh.mobile.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.servlet.view.AbstractView;

public class MobileJsonView extends AbstractView {

	public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String DEFAULT_CHAR_ENCODING = "UTF-8";//编码方式
    
	@Override
	protected void renderMergedOutputModel(Map<String, Object> modelMap,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 response.setCharacterEncoding(DEFAULT_CHAR_ENCODING);
	     response.setContentType(DEFAULT_CONTENT_TYPE);
	      System.out.println(modelMap);
//		//去重
//		if(modelMap!=null){
//			modelMap.remove("modelMap");
//		}
//		//获取状态码
//		String resultCode=Constants.RESULT_CODE_0;//默认失败
//		if(modelMap.containsKey(Constants.RESULT_TEXT_CODE)){
//			resultCode=(String)modelMap.get(Constants.RESULT_TEXT_CODE);
//			modelMap.remove(Constants.RESULT_TEXT_CODE);
//		}
//		//状态
//		boolean success=false;
//		if(resultCode.equals(Constants.RESULT_CODE_1)){
//			success=true;
//		}
////		if(modelMap.containsKey(Constants.RESULT_TEXT_SUCCESS)){
////			success=(Boolean)modelMap.get(Constants.RESULT_TEXT_SUCCESS);
////			modelMap.remove(Constants.RESULT_TEXT_SUCCESS);
////		}
//		//错误信息
//		String errorMsg=null;
//		if(modelMap.containsKey(Constants.RESULT_TEXT_ERROR_MSG)){
//			errorMsg=(String)modelMap.get(Constants.RESULT_TEXT_ERROR_MSG);
//			modelMap.remove(Constants.RESULT_TEXT_ERROR_MSG);
//		}
//		//获取执行时间
//		long time=-1;
//		if(modelMap.containsKey("executeTime")){
//			time=(Long)modelMap.get("executeTime");;//执行时间，单位 毫秒
//			modelMap.remove("executeTime");
//		}
		
		JSONObject json = new JSONObject();
//		json.put(Constants.RESULT_TEXT_CODE, resultCode);
////		json.put(Constants.RESULT_TEXT_SUCCESS, success);
//		json.put(Constants.RESULT_TEXT_TIME, time);
//		json.put(Constants.RESULT_TEXT_ERROR_MSG, errorMsg);
//		if(modelMap!=null&&modelMap.size()!=0){
//			json.put(Constants.RESULT_TEXT_BODY, modelMap);//主体内容
//		}
		json.put("aa", "vv");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
