package me.cmnt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.cmnt.model.Member;

@Repository("memberDao")
@SuppressWarnings("unchecked")
public class MemberDaoImpl extends BaseDaoImpl {

	/**
     * 根据条件查找
     * @param obj
     * @param queryType --> 0：查找所有成员，1：根据主键id查找，2：根据账号id查找，3：根据社团id查找，4：根据社团id查找社长
     * @return
     */
	@Override
	public List<Object> query(Object obj, int queryType) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			String HQL = "";
			switch(queryType) {
				case 0: HQL = "from Member"; break;
				case 1: HQL = "from Member where id = " + member.getId(); break;
				case 2: HQL = "from Member where user_id = " + member.getUser_id(); break; 
				case 3: HQL = "from Member where community_id = " + member.getCommunity_id(); break;
				case 4: HQL = "from Member where community_id = " + member.getCommunity_id() + " and member_type = " + member.getMember_type(); break;
				case 5: HQL = "from Member where community_id = " + member.getCommunity_id() + " and member_status = " + member.getMember_status(); break;
			}
			if (!HQL.isEmpty()) {
				return sessionFactory.getCurrentSession().createQuery(HQL).list();
			}
		}
		return null;
	}
	
}
