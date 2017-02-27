package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.dao.BaseDaoI;

public class CommunityServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI communityDao;

	@Override
	public void save(Object obj) {
		communityDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		communityDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		communityDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return communityDao.query(obj, queryType);
	}

}
