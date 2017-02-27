package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.dao.BaseDaoI;

public class WebInfoServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI webInfoDao;

	@Override
	public void save(Object obj) {
		webInfoDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		webInfoDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		webInfoDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return webInfoDao.query(obj, queryType);
	}

}
