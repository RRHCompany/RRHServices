package com.rrh.common.memcached;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MemcachedManager {
	protected final Logger log = Logger.getLogger(getClass().getName());

	@Value("#{configProperties['memcached.url']}")
	private String memcachedUrl;

	private MemcachedClient mclient;
	private boolean isInit = false;

	public void init() {
		if(isInit)
			return;
		isInit = true;
		try {
			MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(memcachedUrl));
			mclient = builder.build();
		} catch (IOException e) {
			log.error("", e);
		}
	}

	/**
	 * 缓存时效 1天
	 */
	public static final int CACHE_EXP_DAY = 3600 * 24;

	/**
	 * 缓存时效 1周
	 */
	public static final int CACHE_EXP_WEEK = 3600 * 24 * 7;

	/**
	 * 缓存时效 1月
	 */
	public static final int CACHE_EXP_MONTH = 3600 * 24 * 30 * 7;

	/**
	 * 缓存时效 永久
	 */
	public static final int CACHE_EXP_FOREVER = 0;
	
	/**
	 * 是否存在
	 * @param key
	 * @return
	 */
	public boolean isContain(String key){
		return get(key) != null;
	}

	/**
	 * 缓存
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            失效时间
	 */
	public boolean put(String key, Object value) {
		return put(key, value, CACHE_EXP_FOREVER);
	}

	/**
	 * 缓存
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            失效时间
	 */
	public boolean put(String key, Object value, int exp) {
		init();
		try {
			mclient.add(key, exp, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		log.debug("Cache Object: [" + key + "]");
		return true;
	}

	/**
	 * 缓存
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            失效时间
	 */
	public boolean replace(String key, Object value, int exp) {
		init();
		try {
			mclient.replace(key, exp, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		log.debug("Cache Object: [" + key + "]");
		return true;
	}

	/**
	 * 清理对象
	 * 
	 * @param key
	 */
	public boolean delete(String key) {
		init();
		try {
			mclient.delete(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		log.debug("Flush Object: [" + key + "]");
		return true;
	}

	/**
	 * 加载缓存对象
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		init();
		Object object = null;
		try {
			object = mclient.get(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		log.debug("Load Object: [" + key + "]");
		return object;
	}

	/**
	 * 缓存
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            失效时间
	 */
	public boolean enforceSet(String key, Object value) {
		return enforceSet(key, value, CACHE_EXP_FOREVER);
	}

	/**
	 * 缓存
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 *            失效时间
	 */
	public boolean enforceSet(String key, Object value, int exp) {
		init();
		try {
			mclient.set(key, exp, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		log.debug("Cache Object: [" + key + "]");
		return true;
	}
}
