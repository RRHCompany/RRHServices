package com.rrh.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class CommonUtils {
	private static final String PHONE_ROLE = "^((13[0-9])|145|(15[^4,\\D])|(18[0-9])|(17[0,5-9]))\\d{8}$";
	private static final String REG = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
        + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式  
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式 
	/**
	  * 创建指定数量的随机字符串
	  * @param numberFlag 是否是数字
	  * @param length
	  * @return
	  */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}
	/**
	 * 手机号码验证
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){
		Pattern p = Pattern.compile(PHONE_ROLE);
	    Matcher m = p.matcher(mobiles);  
		return m.matches();  

	}
	/**
	 * 过滤SQL　防注入
	 * @param str
	 * @return
	 */
	public static String encordSQL(String str,int num){
		if(str != null && !"".equals(str)){
			if(num != 0 && num > 0 && str.length() > num){
	    		str = str.substring(0,num);
	    	}
			Pattern p_space = Pattern.compile(REG, Pattern.CASE_INSENSITIVE);  
	        Matcher m_space = p_space.matcher(str);  
	        str = m_space.replaceAll(""); // 过滤空格回车标签  
	        str = delHTMLTag(str);
	        return str;
		}else{
	    	return "";
	    }
	}
	/** 
     * @param htmlStr 
     * @return 
     *  删除Html标签 
     */  
    public static String delHTMLTag(String htmlStr) {  
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
        Matcher m_script = p_script.matcher(htmlStr);  
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(htmlStr);  
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(htmlStr);  
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
  
        return htmlStr.trim(); // 返回文本字符串  
    }
	public static void sendJson(HttpServletResponse response, JSONObject json) throws IOException{
		//在IE10以下版本，必须设置成text/html，不然传到前台，ie浏览器弹出下载保存的对话框
		//getResponse().setContentType("text/json; charset=utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
	}
}
