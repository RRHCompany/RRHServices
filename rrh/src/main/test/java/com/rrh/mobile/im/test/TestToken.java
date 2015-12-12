package com.rrh.mobile.im.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rrh.mobile.im.TokenIM;
import com.rrh.mobile.im.models.SdkHttpResult;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestToken {
	@Test
	public void testToken() throws Exception{
		SdkHttpResult result = null;

//		result = TokenIM.getToken("1", "jason","http://guangdong.sinaimg.cn/2014/1202/U10867P693DT20141202080012.jpg");
//		System.out.println("gettoken=" + result);
	}
	
}
