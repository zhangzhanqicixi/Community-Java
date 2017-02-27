package me.cmnt.dao;

import java.util.List;

public interface BaseDaoI {
	
	/**
	 * 删除
	 * @param obj
	 */
	void delete(Object obj);
	
	/**
	 * 增加
	 * @param obj
	 */
	void save(Object obj);
	
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
