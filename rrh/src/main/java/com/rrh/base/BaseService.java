package com.rrh.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 基础服务，只包含最基本的 增、删、改、查
 * 注：
 *  1、必须用MyBatis Generator反向生成 mapper
 * 	2、生成的 mapper 方法名称不能改动
 * 使用：
 * 	1、继续 BaseService
 * 	2、实现 initMapper，把对应的mapper赋值到baseMapper
 * 	3、使用增、删、改、查方法
 * 
 * @author seff
 * @param <T>
 */
public abstract class BaseService<T> implements IBaseService<T>  {
	protected final Logger log = Logger.getLogger(BaseService.class.getName());
	
	protected Object baseMapper;
	
	private static final String InsertMet = "insert";  //添加
	private static final String SelectByIdMet = "selectByPrimaryKey"; //通过主键查询
	private static final String SelectByModelMet = "selectByModelSelective"; //多条件查询
	private static final String SelectAllMet = "selectAll"; //查询全部
	private static final String UpdateMet = "updateByPrimaryKey";//通过主键更新
	private static final String UpdateMetSelective = "updateByPrimaryKeySelective";//选择性更新
	private static final String DeleteMet = "deleteByPrimaryKey";//通过主键删除
	private static final String SelectByPageMet = "selectRecordByPage";//分页查询
	private static final String SelectRecordCountMet = "selectRecordCount";//分页查询
	public abstract void initMapper();

	@Override
	public void insert(T t) {
		invokeByName(InsertMet, t);
	}

	@Override
	public void update(T t) {
		invokeByName(UpdateMet, t);
	}
	
	@Override
	public void updateSelective(T t) {
		invokeByName(UpdateMetSelective, t);
	}

	@Override
	public void delete(Integer id) {
		invokeByName(DeleteMet, id);
	}

	@Override
	public T selectById(Integer id) {
		return (T) invokeByName(SelectByIdMet, id);
	}

	@Override
	public List<T> SelectByModel(T t) {
		return (List<T>) invokeByName(SelectByModelMet, t);
	}
	
	@Override
	public List<T> selectAll() {
		return (List<T>) invokeByName(SelectAllMet, null);
	}
	
	@Override
	public List<T> selectRecordByPage(HashMap<String,Object> map) {		
		return (List<T>) invokeByName(SelectByPageMet, map);
	}

	@Override
	public Integer selectRecordCount(HashMap<String,Object> map) {		
		return (Integer) invokeByName(SelectRecordCountMet, map);
		
	}
	private Class getBaseMapperClz(){
		if(baseMapper == null){
			initMapper();
			if(baseMapper == null)
				throw new RuntimeException("请先setMapper");
		}
		return baseMapper.getClass();
	}
	
	private Object invokeByName(String methodName, Object... args){
		Method insertMethod;
		Object rtn = null;
		try {
			Class[] paramType = null;
			if(args != null && args.length > 0){
				paramType = new Class[args.length];
				for(int i=0; i<args.length; i++){					
					paramType[i] = args[i].getClass();
				}
			}
			insertMethod = getBaseMapperClz().getDeclaredMethod(methodName, paramType);
			rtn = insertMethod.invoke(baseMapper, args);
		} catch (SecurityException e) {
			log.error("", e);
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			log.error("", e);
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			log.error("", e);
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			log.error("", e);
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			log.error("", e);
			throw new RuntimeException(e);
		}
		return rtn;
	}
}
