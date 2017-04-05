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
import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "community")
@Namespace("/")
@Results({
		@Result(name = "community_list", location = "/jsp/common/community/community.jsp"),
		@Result(name = "community_update", location = "/jsp/common/community/update.jsp"),
		@Result(name = "edit_intro", location = "/jsp/common/community/edit_intro.jsp"),
		@Result(name = "main_community_list", location = "/jsp/main_page/community.jsp")})
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
	private User user;
	private Member member;

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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	/**
	 * 根据条件查找,并赋值到communityList
	 * 
	 * @param entType
	 * @return
	 */
	@Override
	public List<Community> queryByEntType(int entType) {
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
	 * 查找所有社团 - 主页
	 * 
	 * @return
	 */
	public String main_listCommunity() {
		communityList = queryByEntType(0);
		return "main_community_list";
	}

	/**
	 * 更新或插入
	 * 
	 * @return
	 */
	public String saveOrUpdate() {
		if (community.getId() != 9999) {
			// update
			// 更新member状态
			User user = new User();
			user.setUser_id(user_id);
			List<Object> user_list = userService.query(user, 5);
			if (!user_list.isEmpty() && user_list.get(0) instanceof User) {
				user = (User) user_list.get(0);
				// update community
				community.setProper_name(user.getUser_name());
				communityService.update(community);
				Member member = new Member();
				member.setUser_id(user.getId());
				List<Object> member_list = memberService.query(member, 2);
				if (!member_list.isEmpty() && member_list.get(0) instanceof Member) {
					member = (Member) member_list.get(0);
					member.setMember_type(2);
					member.setCommunity_id(community.getId());
					memberService.update(member);
					return ajaxForwardSuccess(getText("更新成功！"));
				}
			}
			return ajaxForwardError(getText("更新失败！请检查学号是否有效"));
		} else {
			// insert
			communityService.save(community);
			return ajaxForwardSuccess(getText("添加成功！"));
		}
	}

	/**
	 * 获得当前id的信息
	 * @return
	 */
	public String getCommunityByUid() {
		if (uid != null && !uid.isEmpty()) {
			community = new Community();
			community.setId(Integer.valueOf(uid));
		}
		community = (Community) queryByEntType(1).get(0);
		
		// 去member表中找社长
		Member member = new Member();
		member.setCommunity_id(community.getId());
		member.setMember_type(2);
		List<Object> member_list = memberService.query(member, 4);
		if(!member_list.isEmpty() && member_list.get(0) instanceof Member) {
			// 存在社长
			member = (Member) member_list.get(0);
			// 修改member表中社长状态为学生状态
			member.setMember_type(1);
			memberService.update(member);
			// 去User表中找user
			User user = new User();
			user.setId(member.getUser_id());
			List<Object> user_list = userService.query(user, 1);
			if (!user_list.isEmpty() && user_list.get(0) instanceof User) {
				user = (User) user_list.get(0);
			}
			user_id = user.getUser_id();
		} else {
			// 如果没有社长
			// pass
		}
		
		return "community_update";
	}
	
	/**
	 * 根据userId,准备修改社团简介信息
	 * @return
	 */
	public String edit_intro() {
		// 查找该用户所属的community
		if (user_id == null || user_id.isEmpty()) {
			return ajaxForwardError("该用户没有主键，请重新登录");
		}
		user = new User();
		user.setId(Integer.valueOf(user_id));
		List<Object> user_list = userService.query(user, 1);
		if (user_list == null || user_list.isEmpty()) {
			return ajaxForwardError("当前用户环境错误，请重新登录");
		}
		user = (User) user_list.get(0);
		// 根据user去找member
		member = new Member();
		member.setUser_id(user.getId());
		List<Object> member_list = memberService.query(member, 2);
		if (member_list == null || member_list.isEmpty()) {
			return ajaxForwardError("找不到该成员信息，请重新登录");
		}
		member = (Member) member_list.get(0);
		community = new Community();
		community.setId(member.getCommunity_id());
		List<Community> community_list = queryByEntType(1);
		if (community_list == null || community_list.isEmpty()) {
			return ajaxForwardError("找不到该社团信息");
		}
		community = (Community) community_list.get(0);
		return "edit_intro";
	}
	
	/**
	 * 更新简介
	 * @return
	 */
	public String update_intro(){
		if (community == null) {
			return ajaxForwardError("更新失败！");
		}
		communityService.update(community);
		return ajaxForwardSuccess("更新成功！");
	}
	
}
