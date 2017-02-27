package me.cmnt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.cmnt.model.WebMsg;

@Repository("webMsgDao")
@SuppressWarnings("unchecked")
public class WebMsgDaoImpl extends BaseDaoImpl{

	/**
     * 根据条件查找用户
     * @param obj
     * @param queryType --> 0：查找所有用户，1：根据id查找，2：根据user_id查找
     * @return
     */
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof WebMsg) {
			WebMsg webMsg = (WebMsg) obj;
			String HQL = "";
			switch(queryType) {
				case 0: HQL = "from WebMsg"; break;
				case 1: HQL = "from WebMsg where id = " + webMsg.getId(); break;
				case 2: HQL = "from WebMsg where user_id = " + webMsg.getUser_id(); break;
				default: break;
			}
			if (!HQL.isEmpty()) {
				return sessionFactory.getCurrentSession().createQuery(HQL).list();
			}
		}
		return null;
	}

}
