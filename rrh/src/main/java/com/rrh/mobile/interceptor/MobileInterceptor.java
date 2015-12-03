package com.rrh.mobile.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * mobile 路径拦截器
 * */
public class MobileInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		long startTime = System.currentTimeMillis();
//		request.setAttribute("execute_start_time", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

//		long startTime = (Long) request.getAttribute("execute_start_time");
//		long endTime = System.currentTimeMillis();
//		long executeTime = endTime - startTime;
//		// modified the exisitng modelAndView
//		modelAndView.addObject("executeTime", executeTime);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
