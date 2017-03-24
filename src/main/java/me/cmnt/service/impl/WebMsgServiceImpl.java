package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cmnt.dao.BaseDaoI;

@Service("webMsgService")
public class WebMsgServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI webMsgDao;

	@Override
	public void save(Object obj) {
		webMsgDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		webMsgDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		webMsgDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return webMsgDao.query(obj, queryType);
	}

}
