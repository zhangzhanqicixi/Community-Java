package me.cmnt.service;

import java.util.List;

public interface BaseServiceI {
	
	/**
	 * 增加
	 * @param obj
	 */
	void save(Object obj);
	
	/**
	 * 删除
	 * @param obj
	 */
	void delete(Object obj);
	
	/**
	 * 更新
	 * @param obj
	 */
	void update(Object obj);
	
	/**
	 * 查找
	 * @param obj
	 * @param queryType
	 * @return
	 */
	List<Object> query(Object obj, int queryType);

}
