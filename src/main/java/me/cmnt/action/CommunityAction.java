package me.cmnt.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;

import me.cmnt.model.Community;
import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;
import me.cmnt.util.Util;

@ParentPackage("basePackage")
@Action(value = "community")
@Namespace("/")
@InterceptorRefs(value = {
		@InterceptorRef(value = "fileUpload", params = {
				"maximumSize", "209715200",
				"allowedExtensions", ".jpg, .jpeg, .png"
		}),
		@InterceptorRef(value = "defaultStack")
})
@Results({
		@Result(name = "community_list", location = "/jsp/common/community/community.jsp"),
		@Result(name = "community_update", location = "/jsp/common/community/update.jsp"),
		@Result(name = "edit_intro", location = "/jsp/common/community/edit_intro.jsp"),
		@Result(name = "main_community_list", location = "/jsp/main_page/community.jsp"),
})
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
	private String msg;
	private String user_id_origin;
	// 封装上传文件域的属性
	private File file;
	private String fileFileName;
	private String fileContentType;

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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getUser_id_origin() {
		return user_id_origin;
	}
	public void setUser_id_origin(String user_id_origin) {
		this.user_id_origin = user_id_origin;
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
			List<Object> listObjects = communityService.query(community,
					entType);
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
			// 1. 判断社团名称是否有重复
			List community_list = communityService.query(community, 2);
			if (community_list == null || community_list.size() > 1) {
				return ajaxForwardError(getText("社团名称重复，请重试！"));
			}
			// 2 判断学号是否有变动
			if (!user.getUser_id().equals(uid)) {
				// 2.1 判断这个学号是否存在
				List user_list = userService.query(user, 5);
				if (user_list == null || user_list.isEmpty()) {
					return ajaxForwardError(getText("该学号不存在，请重试！"));
				}
				user = (User) user_list.get(0);
				//// 2.2 判断该人是否已加入该社团
				// 2.2 （以此为准）判断该人是否已有社长职务
				Member member = new Member();
				member.setUser_id(user.getId());
				member.setMember_type(2);
				List member_list = memberService.query(member, 8);
				if (!member_list.isEmpty()) {
					return ajaxForwardError(getText("该用户已成为其他社团社长！"));
				}
				if (user_id_origin != null) {
					// 2.2 撤去原社长
					member = new Member();
					member.setUser_id(Integer.valueOf(user_id_origin));
					member.setMember_type(2);
					List member_list_origin = memberService.query(member, 8);
					if (member_list_origin != null && !member_list_origin.isEmpty()) {
						member = (Member) member_list_origin.get(0);
						member.setMember_type(1);
						memberService.delete(member);
					}
				}
				
				// 2.3 任命新社长
				member = new Member();
				member.setCommunity_id(community.getId());
				member.setUser_id(user.getId());
				member.setMember_status(1);
				member.setMember_type(2);
				memberService.save(member);
			}
			
			// 3. 图片
			if (file != null) {
				String destString = ServletActionContext
						 .getServletContext().getRealPath("/community_upload")
						 + "/" + fileFileName;
						 try {
							FileUtils.copyFile(file, new File(destString));
						} catch (IOException e) {
							e.printStackTrace();
						}
				community.setCommunity_img_path("community_upload/" + fileFileName);
			}
			communityService.update(community);
			return ajaxForwardSuccess(getText("更新成功！"));
			
		} else {
			// insert
			if (file != null) {
				 String destString = ServletActionContext
				 .getServletContext().getRealPath("/community_upload")
				 + "/" + fileFileName;
				 try {
					FileUtils.copyFile(file, new File(destString));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ajaxForwardError(getText("上传图片失败，请重试！"));
				}
				 community.setCommunity_img_path("community_upload/" + fileFileName);
			}
			communityService.save(community);
			return ajaxForwardSuccess(getText("添加成功！"));
		}
	}

	public String delete() {
		if (uid == null) {
			return ajaxForwardError("社团编号出错！");
		}
		Member member = new Member();
		member.setCommunity_id(Integer.valueOf(uid));
		List member_list = memberService.query(member, 3);
		// 删除该社团全部成员
		if (member_list != null) {
			for (Object object : member_list) {
				if (object instanceof Member) {
					member = (Member) object;
					memberService.delete(member);
				}
			}
		}
		Community community = new Community();
		community.setId(Integer.valueOf(uid));
		// 删除该社团
		communityService.delete(community);
		return ajaxForwardSuccess("删除成功！");
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
		// 去member表找社长
		Member member = new Member();
		member.setCommunity_id(community.getId());
		member.setMember_type(2);
		List member_list = memberService.query(member, 4);
		if (member_list != null && !member_list.isEmpty()) {
			this.member = (Member) member_list.get(0);
			// 找出该社长的user信息
			int user_id = this.member.getUser_id();
			User user = new User();
			user.setId(user_id);
			List user_list = userService.query(user, 1);
			if (user_list != null && !user_list.isEmpty()) {
				this.user = (User) user_list.get(0);
			}
		}
		return "community_update";
	}

	/**
	 * 根据userId,准备修改社团简介信息
	 * 
	 * @return
	 */
	public String edit_intro() {
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		member = (Member) session.get("member");
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
	 * 
	 * @return
	 */
	public String update_intro() {
		if (community == null) {
			return ajaxForwardError("更新失败！");
		}
		if (file != null) {
			 String destString = ServletActionContext
			 .getServletContext().getRealPath("/community_upload")
			 + "/" + fileFileName;
			 try {
				FileUtils.copyFile(file, new File(destString));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ajaxForwardError(getText("上传图片失败，请重试！"));
			}
			 community.setCommunity_img_path("community_upload/" + fileFileName);
		}
		communityService.update(community);
		return ajaxForwardSuccess("更新成功！");
	}

}
