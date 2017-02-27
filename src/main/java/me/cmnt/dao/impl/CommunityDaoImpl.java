package me.cmnt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.cmnt.model.Community;

@Repository("communityDao")
@SuppressWarnings("unchecked")
public class CommunityDaoImpl extends BaseDaoImpl{

	/**
     * 根据条件查找用户
     * @param obj
     * @param queryType --> 0：查找所有社团，1：根据id查找
     * @return
     */
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof Community) {
			Community community = (Community) obj;
			String HQL = "";
			switch (queryType) {
				case 0: HQL = "from Community"; break;
				case 1: HQL = "from Community where id = " + community.getId();
				default: break;
			}
			if (!HQL.isEmpty()) {
				return sessionFactory.getCurrentSession().createQuery(HQL).list();
			}
		}
		return null;
	}

}
