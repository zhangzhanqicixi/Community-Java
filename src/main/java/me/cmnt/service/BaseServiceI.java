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
	 * @param obj 要找到的实例类
	 * @param queryType 查找类型，默认0为全部查找，1为按主键id查找
	 * @return
	 */
	List<Object> query(Object obj, int queryType);

}
