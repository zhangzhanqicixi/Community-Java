package me.cmnt.service.impl;

import java.util.List;

import me.cmnt.service.BaseServiceI;

public abstract class BaseServiceImpl implements BaseServiceI {
	
	public abstract void save(Object obj);
	
	public abstract void delete(Object obj);
	
	public abstract void update(Object obj);
	
	public abstract List<Object> query(Object obj, int queryType);
	
}
