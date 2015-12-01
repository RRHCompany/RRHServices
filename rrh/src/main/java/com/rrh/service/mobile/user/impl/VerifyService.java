package com.rrh.service.mobile.user.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseResponse;
import com.rrh.base.BaseService;
import com.rrh.common.CommonUtils;
import com.rrh.common.ErrorMsgConstant;
import com.rrh.common.MemcachedManager;
import com.rrh.common.SystemConstant;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.mapper.user.TbVerifyMapper;
import com.rrh.model.user.TbVerify;
import com.rrh.service.mobile.user.IVerifyService;

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
	 * 获取难验证码 type 1 注册  2 忘记密码 
	 */
	public BaseResponse createVerifyCode(String mobile,String type){
		if(StringUtils.isEmpty(mobile)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try{
			boolean flag = verifyMobile(mobile, type);
			if(flag){
				//随机验证码
				String code = CommonUtils.createRandom(true, 4);//4位的数字验证码
				HashMap<String,Object> map = new HashMap<String, Object>();
				map.put("tab", Integer.valueOf(type));
				map.put("mobile", mobile);
				map.put("code", CommonUtils.encordSQL(code,0));
				map.put("returnValue", 0);
				tbVerifyMapper.createVerify(map);	
				Integer result = (Integer)map.get("returnValue");
				if(result != null && result != -1){					
					//调用发送短信接口
					boolean sendOk = true;
					if(sendOk){
						memcachedManager.enforceSet(mobile, code, 3600);//3600秒有效期
						return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
					}else{
						return new BaseResponse(ErrorMsgConstant.SMS_SEND_CODE_CHECKED_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
					}
					
				}else{
					return new BaseResponse(ErrorMsgConstant.SMS_CREATE_VERIFY_MOREREQUEST_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}
			}else{
				return new BaseResponse(type.equals("1")?ErrorMsgConstant.USER_PHONE_HAD_RESGISTER_ERRORCODE:ErrorMsgConstant.USER_EXTEND_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
			}
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	
		
	/**
	 * 校验手机号码是否注册
	 * @param mobile
	 * @return
	 */
	public boolean verifyMobile(String mobile,String type){		
		try {
			int userId = tbUsersMapper.selectUserIdByPhone(mobile);
			if(type.equals("1")){
				//电话号码已注册
				if(userId > 0){
					return false;
				}else{
					return true;
				}
			}else{
				//电话号码已注册
				if(userId > 0){
					return true;
				}else{
					return false;
				}
			}
			
		} catch (Exception e) {
			log.error("", e);
			return false;
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
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		int result = verifyCode_(mobile,type,code);
		if(result == 1){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(result == -4){
			return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
		}else{
			return new BaseResponse(ErrorMsgConstant.SMS_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
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
