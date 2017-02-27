package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.dao.BaseDaoI;

public class MemberServiceImpl extends BaseServiceImpl {
	
	@Autowired
	private BaseDaoI memberDao;

	@Override
	public void save(Object obj) {
		memberDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		memberDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		memberDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return memberDao.query(obj, queryType);
	}

}
