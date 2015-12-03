package com.rrh.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author jason
 * @data 2015-12-3
 */
public class RegexpUtil {
	/**手机号码*/
	private static final String Mobile_REGEXP = "^((13[0-9])|145|(15[^4,\\D])|(18[0-9])|(17[0,5-9]))\\d{8}$";
	/**手机号码验证*/
	public static boolean isMobile(String input){
		Pattern p = Pattern.compile(Mobile_REGEXP);
	    Matcher m = p.matcher(input);  
		return m.matches();  
	}
}
