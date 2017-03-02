package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.Community;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "community")
@Namespace("/")
@Results({ @Result(name = "community_list", location = "/jsp/common/community/community.jsp") })
public class CommunityAction {

	@Autowired
	private BaseServiceI communityService;
	private String uid;
	private List<Community> communityList;
	public List<Community> getCommunityList() {
		return communityList;
	}
	public void setCommunityList(List<Community> communityList) {
		this.communityList = communityList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 查找所有社团
	 * @return
	 */
	public String listCommunity() {
		communityList = new ArrayList<Community>();
		List<Object> listObject = communityService.query(new Community(), 0);
		for (Object cmnt : listObject) {
			if (cmnt instanceof Community) {
				communityList.add((Community)cmnt);
			}
		}
		return "community_list";
	}
	
	public void updateCommunity() {
		System.out.println(uid);
	}



	

}
