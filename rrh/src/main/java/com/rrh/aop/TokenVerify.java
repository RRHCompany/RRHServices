package com.rrh.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseRequest;
import com.rrh.common.TokenUtils;

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
		String key = pjp.getTarget().getClass().getName() + "."  
                + pjp.getSignature().getName();
		log.info(key + "===  in  ==============================>");
		long curr = System.currentTimeMillis();
		Object o = pjp.proceed();
		log.info(key + "===  cost:"
				+ (System.currentTimeMillis() - curr)
				+ "ms==============================>");
		log.info(key + "===  out  ==============================>");
		return o;
	}
}
