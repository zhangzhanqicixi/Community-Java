package me.cmnt.service.impl;

import java.util.List;

import me.cmnt.dao.BaseDaoI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activityService")
public class ActivityServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI activityDao;
	
	@Override
	public void save(Object obj) {
		activityDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		activityDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		activityDao.update(obj);
	}
	
	@Override
	public List<Object> query(Object obj, int queryType) {
		return activityDao.query(obj, queryType);
	}

}
