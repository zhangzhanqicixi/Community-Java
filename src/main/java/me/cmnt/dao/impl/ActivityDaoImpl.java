package me.cmnt.dao.impl;

import java.util.List;

import me.cmnt.model.Activity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("activityDao")
@SuppressWarnings("unused")
public class ActivityDaoImpl extends BaseDaoImpl {

	/**
     * 根据条件查找用户
     * @param obj
     * @param queryType --> 0：查找所有用户，1：根据id查找，2：根据community_id查找
     * @return
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof Activity) {
			Activity activity = (Activity) obj;
			String HQL = "";
			switch (queryType) {
				case 0: HQL = "from Activity"; break;
				case 1: HQL = "from Activity where id = " + activity.getId(); break;
				case 2: HQL = "from Activity where community_id =" + activity.getCommunity_id(); break;
				case 3: HQL = "from Activity"; break;
				default: break;
			}
			if (!HQL.isEmpty()) {
				if (queryType == 3) {
					return sessionFactory.getCurrentSession().createQuery(HQL).setMaxResults(10).list();
				} else {
					return sessionFactory.getCurrentSession().createQuery(HQL).list();
				}
			}
		}
		return null;
	}

}
