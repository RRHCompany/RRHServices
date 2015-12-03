package com.rrh.base;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.rrh.mobile.SystemConstant;

public class BaseController {

	protected final Logger log = Logger.getLogger(getClass().getName());
	
	protected boolean isUserTimeout(HttpSession session){
		return session.getAttribute(SystemConstant.BACK_ADMIN) == null;
	}
}
