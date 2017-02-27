package me.cmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cmnt.dao.BaseDaoI;

//使用Spring提供的@Service注解将UserServiceImpl标注为一个Service
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl {
	
	/**
	 * 自动注入
	 */
    @Autowired
    private BaseDaoI userDao;

	@Override
	public void save(Object obj) {
		userDao.save(obj);
	}

	@Override
	public void delete(Object obj) {
		userDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		userDao.update(obj);
	}

	@Override
	public List<Object> query(Object obj, int queryType) {
		return userDao.query(obj, queryType);
	}

}
