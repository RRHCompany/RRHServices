package com.rrh.mobile.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rrh.base.BaseController;
import com.rrh.mobile.ConstantsMobile;
import com.rrh.mobile.base.BaseRequest;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.req.UserLoginOtherRequest;
import com.rrh.mobile.bean.req.UserPerfectInfoRequest;
import com.rrh.mobile.bean.req.UserRegisterRequest;
import com.rrh.mobile.service.user.IUserService;
import com.rrh.model.user.TbUsers;

@Controller
@RequestMapping(ConstantsMobile.MOBOLE_V_1_0_PRE+"users")
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
	public BaseResponse register(UserRegisterRequest bean){
		return userService.phoneRegister(bean);
	}
	//查询我的信息
	@RequestMapping("getUserInfo")
	@ResponseBody
	public BaseResponse getUserInfo(@RequestParam String userId){
		return userService.getUserInfo(userId);
	}
	//修改个人信息提交
	@RequestMapping("perfectInfo")
	@ResponseBody
	public BaseResponse perfectInfo(UserPerfectInfoRequest bean){
		return userService.perfectInfo(bean);
	}
	//修改密码
	@RequestMapping("recoverPwd")
	@ResponseBody
	public BaseResponse recoverPwd(@RequestParam String mobile,@RequestParam String password,@RequestParam String verifyCode){
		return userService.recoverPwd(mobile, password, verifyCode);
	}
	//修改密码
	@RequestMapping("modifyPwd")
	@ResponseBody
	public BaseResponse modifyPwd(@RequestParam String userId,@RequestParam String password,@RequestParam String newPassword){
		return userService.modifyPwd(userId, password, newPassword);
	}
	//第三方登录 
	@RequestMapping("loginOther")
	@ResponseBody
	public BaseResponse loginOther(UserLoginOtherRequest bean){
		return userService.loginOther(bean);
	}
	//上传用户头像
	@RequestMapping("uploadUserImg")
	@ResponseBody
	public BaseResponse uploadUserImg(@RequestParam MultipartFile file, @RequestParam String photoSuffix, @RequestParam String userId){
		return userService.uploadUserImg(file, photoSuffix, userId);
	}
	
}
