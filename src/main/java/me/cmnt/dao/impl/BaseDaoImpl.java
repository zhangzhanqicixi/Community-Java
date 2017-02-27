package me.cmnt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.dao.BaseDaoI;
import me.cmnt.model.User;

public abstract class BaseDaoImpl implements BaseDaoI {

	/**
     * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
     */
    @Autowired
    protected SessionFactory sessionFactory;
    
    @Override
    public void save(Object obj) {
    	sessionFactory.getCurrentSession().save(obj);
    }
    
	@Override
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
	
	@Override
	public void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}
	
	public abstract List<Object> query(Object obj, int queryType);

}
