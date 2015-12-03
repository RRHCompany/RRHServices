package com.rrh.mobile.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rrh.mobile.base.BaseRequest;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.utils.TokenUtils;

@Component
@Lazy
public class TokenVerify {
	protected final Logger log = Logger.getLogger(getClass().getName());
	
	@Value("#{configProperties['aop.token.exclude']}")
	private String aopTokenExclude;
	
	
	public void doBefore(JoinPoint point) {
		String method = point.getTarget().getClass().getName() + "."  
                + point.getSignature().getName();
		if(aopTokenExclude.indexOf(method) > -1)
			return;
		
		// 根据token转换出userId
		Object[] args=point.getArgs();
		BaseRequest req = null;
		for (int i = 0; i < args.length; i++) {
			if(args[i] instanceof BaseRequest){
				req = ((BaseRequest)args[i]);
				break;
			}
		}
		if(req == null || StringUtils.isEmpty(req.getToken()))
			return;
		
		try {
			Integer userId = Integer.valueOf(TokenUtils.getUserIdByToken(req.getToken()));
			req.setBaseId(userId);
		} catch (Exception e) {
			log.error("", e);
		}
    }
	
	// 声明环绕通知
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		String key = pjp.getTarget().getClass().getName() + "."+ pjp.getSignature().getName();
		long curr = System.currentTimeMillis();
		Object o = pjp.proceed();
		if(o != null && o instanceof BaseResponse){
			BaseResponse resp = (BaseResponse)o;
			resp.setTime(String.valueOf(System.currentTimeMillis() - curr));
			log.info(key + "执行时间:"+ resp.getTime()+ "ms");
		}
		return o;
	}
}
