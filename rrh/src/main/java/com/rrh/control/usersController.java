package com.rrh.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrh.base.BaseController;
import com.rrh.base.BaseResponse;
import com.rrh.bean.req.UserRegisterRequest;
import com.rrh.model.user.TbUsers;
import com.rrh.service.user.IUserService;

@Controller
@RequestMapping("users")
public class usersController extends BaseController{

	@Autowired
	private IUserService<TbUsers> userService;
	//用户登录
	@RequestMapping("login")
	@ResponseBody
	public BaseResponse login(@RequestParam String mobile, @RequestParam String password, HttpSession session){
		return userService.phoneLogin(mobile, password);
	}
	//校验用户名
	@RequestMapping("verifyUserByUserName")
	@ResponseBody
	public BaseResponse verifyUserByUserName(@RequestParam String userName, HttpSession session){
		return userService.verifyUserByUserName(userName);
	}
	//用户注册
	@RequestMapping("register")
	@ResponseBody
	public BaseResponse register(UserRegisterRequest userRegisterRequest){
		return userService.userRegister(userRegisterRequest);
	}
}
