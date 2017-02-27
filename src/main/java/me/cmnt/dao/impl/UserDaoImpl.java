package me.cmnt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.cmnt.model.User;

@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl {
	
	/**
     * 根据条件查找用户
     * @param obj
     * @param queryType --> 0：查找所有用户，1：根据id查找，2：根据username查找，3：根据user_type查找
     * @return
     */
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof User) {
			User user = (User) obj;
			String HQL = "";
			switch (queryType) {
				case 0: HQL = "from User"; break;
				case 1: HQL = "from User where id = " + user.getId();
				case 2: HQL = "from User where username = " + user.getUsername();
				case 3: HQL = "from User where user_type = " + user.getUser_type();
				default: break;
			}
			if (!HQL.isEmpty()) {
				return sessionFactory.getCurrentSession().createQuery(HQL).list();
			}
		}
		return null;
	}

}
