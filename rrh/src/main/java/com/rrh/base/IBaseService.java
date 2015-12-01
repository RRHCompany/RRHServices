package com.rrh.base;

import java.util.HashMap;
import java.util.List;

public interface IBaseService<T> {

	public void insert(T t);
	
	public void update(T t);
	
	public void updateSelective(T t); 
	
	public void delete(Integer id);
	
	public T selectById(Integer id);
	
	public List<T> SelectByModel(T t);
	
	public List<T> selectAll();

	public List<T> selectRecordByPage(HashMap<String,Object> map);

	public Integer selectRecordCount(HashMap<String,Object> map);
}
