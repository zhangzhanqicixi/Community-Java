package me.cmnt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("webInfoDao")
public class WebInfoDaoImpl extends BaseDaoImpl {

	/**
	 * 网页信息只做更新和插入操作
	 */
	@Override
	public List<Object> query(Object obj, int queryType) {
		// TODO Auto-generated method stub
		return null;
	}

}
