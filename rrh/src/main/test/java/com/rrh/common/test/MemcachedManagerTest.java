package com.rrh.common.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rrh.common.memcached.MemcachedManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MemcachedManagerTest {

	@Autowired
	private MemcachedManager memcachedManager;
	
	@Test
	public void putTest(){
		String s = "1";
		memcachedManager.enforceSet("key", "");
		System.out.println( memcachedManager.get("key"));
	}
	
	public static void main(String[] args) throws Exception {
	}
}
