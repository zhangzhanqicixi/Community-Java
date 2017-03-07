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
	private List<Community> communityList;
	private String uid;
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
			Community community = new Community();
			switch (entType) {
			case 1:
				community.setId(Integer.valueOf(uid));
				break;
			default:
				break;
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
		setCommunityList(queryByEntType(0));
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
			System.out.println("update");
			System.out.println(community.getCommunity_name());
			communityService.update(community);
			return ajaxForwardSuccess(getText("更新成功！"));
		} else {
			// insert
			System.out.println("insert");
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
		community = (Community) queryByEntType(1).get(0);
		return "community_update";
	}

}
