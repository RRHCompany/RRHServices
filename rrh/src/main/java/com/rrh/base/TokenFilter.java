package com.rrh.base;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rrh.common.ErrorMsgConstant;
import com.rrh.common.MemcachedManager;
import com.rrh.common.SystemConstant;
import com.rrh.common.TokenUtils;
import com.rrh.model.user.TbUsers;
import com.rrh.service.user.IUserService;

public class TokenFilter implements Filter {
	
	private ServletContext servletContext;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//String root = request.getContextPath();
		String path = request.getRequestURI();
		//登录方法
		path = path.substring(path.lastIndexOf("/")+1,path.length());
		String token = request.getParameter("token");
		
		if(!SystemConstant.LOGINFILTER_METHOD_FREE.contains(path)){
			// 校验token是否合法
			JSONObject errorJson = (JSONObject) JSON.toJSON(new BaseResponse(ErrorMsgConstant.TOKEN_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME));
			if(!StringUtils.isEmpty(token)){
				WebApplicationContext context =  (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				IUserService<TbUsers> loginService = (IUserService<TbUsers>) context.getBean("loginService");
				MemcachedManager memcachedManager = (MemcachedManager) context.getBean("memcachedManager");				
				try {
					String userIdStr = TokenUtils.getUserIdByToken(token);
					if(StringUtils.isEmpty(userIdStr) || !isNumeric(userIdStr)){
						com.rrh.common.CommonUtils.sendJson((HttpServletResponse) response, errorJson);
						return;
					}
					//缓存没有命中，查询数据库
					if(!memcachedManager.isContain(userIdStr)){
						Integer userId = Integer.valueOf(userIdStr);
						TbUsers userInfo = loginService.selectById(userId);
						if(userInfo == null){
							com.rrh.common.CommonUtils.sendJson((HttpServletResponse) response, errorJson);
							return;
						}else{
							memcachedManager.enforceSet(userId.toString(), "");
						}
					}
				} catch (Exception e) {
					com.rrh.common.CommonUtils.sendJson((HttpServletResponse) response, errorJson);
					return;
				}
			}else{
				com.rrh.common.CommonUtils.sendJson((HttpServletResponse) response, errorJson);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		servletContext =config.getServletContext();
	}
	
	public static boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
	       return false; 
		}
		return true; 
	}	
}
