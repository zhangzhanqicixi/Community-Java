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
@Results({
		@Result(name = "community_list", location = "/jsp/common/community/community.jsp"),
		@Result(name = "community_update", location = "/jsp/common/community/update.jsp") })
public class CommunityAction extends BaseAction {

	@Autowired
	private BaseServiceI communityService;
	@Autowired
	private BaseServiceI memberService;
	@Autowired
	private BaseServiceI userService;
	private List<Community> communityList;
	private String uid;
	private String user_id;
	private Community community;

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
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * 根据条件查找,并赋值到communityList
	 * 
	 * @param entType
	 * @return
	 */
	@Override
	public List queryByEntType(int entType) {
		try {
			List<Community> listObj = new ArrayList<Community>();
			if (community == null) {
				community = new Community();
			}
			List<Object> listObjects = communityService.query(community, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof Community) {
					listObj.add((Community) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;
		}
		
	}

	/**
	 * 查找所有社团
	 * 
	 * @return
	 */
	public String listCommunity() {
		communityList = queryByEntType(0);
		return "community_list";
	}

	/**
	 * 更新或插入
	 * 
	 * @return
	 */
	public String saveOrUpdate() {
		if (community.getId() != 9999) {
			// update 
			communityService.update(community);
			return ajaxForwardSuccess(getText("更新成功！"));
		} else {
			// insert
			communityService.save(community);
			return ajaxForwardSuccess(getText("添加成功！"));
		}
	}

	/**
	 * 获得当前id的信息
	 * 
	 * @return
	 */
	public String getCommunityByUid() {
		if (uid != null && !uid.isEmpty()) {
			community = new Community();
			community.setId(Integer.valueOf(uid));
		}
		community = (Community) queryByEntType(1).get(0);
		
		// 去member表中找社长
		
		// 去User表中找user
		
		// 讲user中的名字赋值
		return "community_update";
	}

}
