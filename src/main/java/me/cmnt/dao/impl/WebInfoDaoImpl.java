package me.cmnt.dao.impl;

import java.util.List;

import me.cmnt.model.WebInfo;

import org.springframework.stereotype.Repository;

@Repository("webInfoDao")
public class WebInfoDaoImpl extends BaseDaoImpl {

	/**
	 * 网页信息只做更新和插入操作
	 */
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof WebInfo) {
				WebInfo webInfo = (WebInfo)obj;
				String HQL = "";
				switch (queryType) {
					case 0: HQL = "from WebInfo"; break;
					default: break;
				}
				if (!HQL.isEmpty()) {
					return sessionFactory.getCurrentSession().createQuery(HQL).list();
				}
			}
		return null;
	}

}
