package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.dao.BaseDaoI;

public class WebNewsServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI webNewsDao;

	@Override
	public void save(Object obj) {
		webNewsDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		webNewsDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		webNewsDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return webNewsDao.query(obj, queryType);
	}

}
