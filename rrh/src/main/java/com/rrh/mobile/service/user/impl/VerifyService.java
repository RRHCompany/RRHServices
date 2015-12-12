package com.rrh.mobile.service.user.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseService;
import com.rrh.common.memcached.MemcachedManager;
import com.rrh.common.utils.CommonUtils;
import com.rrh.common.utils.RegexpUtil;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.mapper.user.TbVerifyMapper;
import com.rrh.mobile.ConstantsMobile;
import com.rrh.mobile.ErrorMsgConstant;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.service.user.IVerifyService;
import com.rrh.model.user.TbVerify;

@Service
public class VerifyService extends BaseService<TbVerify> implements IVerifyService<TbVerify> {

	@Autowired
	private TbUsersMapper tbUsersMapper;
	@Autowired
	private TbVerifyMapper tbVerifyMapper;
	@Autowired
	private MemcachedManager memcachedManager;

	@Override
	public void initMapper() {
		this.baseMapper = tbUsersMapper;
	}
	
	/**
	 * 获取验证码 type 1 注册  2 忘记密码 
	 */
	@Override
	public BaseResponse createVerifyCode(String mobile,String type){
		if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(type)){
			return ResultMobile.resultErroParam();
		}
		if(!RegexpUtil.isMobile(mobile)){
			return ResultMobile.resultFall("user.mobile.format.error");
		}
		try{
			int userCount=tbUsersMapper.countByMobile(mobile);
			if(userCount>0){
				return ResultMobile.resultFall("user.mobile.exists");
			}
			//随机验证码
			String code = CommonUtils.createRandom(true, 4);//4位的数字验证码
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("tab", Integer.valueOf(type));
			map.put("mobile", mobile);
			map.put("code", CommonUtils.encordSQL(code,0));
			map.put("returnValue", 0);
			tbVerifyMapper.createVerify(map);	
			Integer result = (Integer)map.get("returnValue");
			if(result == null || result == -1){					
				return ResultMobile.resultFall("sms.verify.req.often");
			}
			//调用发送短信接口
			boolean sendOk = true;
			if(sendOk){
				memcachedManager.enforceSet(mobile, code, 3600);//3600秒有效期
				return ResultMobile.resultSuccess(null);
			}else{
				return ResultMobile.resultFall("sms.verify.send.error");
			}
		}catch(Exception e){
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	
	/**
	 * 校验验证码
	 * @param mobile
	 * @param type 1 为注册校验   2 为忘记密码校验
	 * @param code
	 * @return
	 */
	public BaseResponse verifyCode(String mobile,String type,String code){
		if(StringUtils.isEmpty(mobile)){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
		}else if(!RegexpUtil.isMobile(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE);
		}
		int result = verifyCode_(mobile,type,code);
		if(result == 1){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS);
		}else if(result == -4){
			return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE);
		}else{
			return new BaseResponse(ErrorMsgConstant.SMS_ERRORCODE);
		}
	}
	/**
	 * 校验验证码
	 * @param mobile
	 * @param type 1 为注册校验   2 为忘记密码校验
	 * @param code
	 * @return
	 */
	public int verifyCode_(String mobile,String type,String code){
		
		try{
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("tab", Integer.valueOf(type));
			map.put("mobile", mobile);
			map.put("code", CommonUtils.encordSQL(code, 0));
			map.put("returnValue", 0);
			tbVerifyMapper.verifyCode(map);	
			return (Integer)map.get("returnValue");			
		}catch(Exception e){
			log.error("", e);
			return -3;
		}
	}
}
