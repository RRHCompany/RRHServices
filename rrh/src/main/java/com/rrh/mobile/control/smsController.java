package com.rrh.mobile.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrh.base.BaseController;
import com.rrh.mobile.ConstantsMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.service.user.IVerifyService;
import com.rrh.model.user.TbVerify;

@Controller
@RequestMapping(ConstantsMobile.MOBOLE_V_1_0_PRE+"sms")
public class smsController extends BaseController{

	@Autowired
	private IVerifyService<TbVerify> verifyService;

	//生成验证码
	@RequestMapping("createVerifyCode")
	@ResponseBody
	public BaseResponse createVerifyCode(@RequestParam String mobile, @RequestParam String type, HttpSession session){
		return verifyService.createVerifyCode(mobile, type);		
	}
	//校验验证码
	@RequestMapping("verifyCode")
	@ResponseBody
	public BaseResponse verifyCode(@RequestParam String mobile, @RequestParam String type,@RequestParam String code, HttpSession session){
		return verifyService.verifyCode(mobile,type,code);		
	}
}
