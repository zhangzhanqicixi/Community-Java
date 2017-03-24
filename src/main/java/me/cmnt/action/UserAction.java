package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import me.cmnt.model.Community;
import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "user")
@Namespace("/")
@Results({
	@Result(name = "stu_page", location = "/index.jsp"),
	@Result(name = "cmnt_page", location = "/WEB-INF/cmnt_admin.jsp"), 
	@Result(name = "admin_page", location = "/WEB-INF/admin.jsp"),
	@Result(name = "logout", location= "/login.jsp")
	})
public class UserAction extends BaseAction {

	@Autowired
	private BaseServiceI userService;
	@Autowired
	private BaseServiceI memberService;
	private List<User> userList;
	private User user;
	private Member member;
	private String uid;
	// 判断登录类型，1.学生/2.社长/3.管理员
	private String flag;
	private String loginFlag;
	private String username;
	private String password;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public List<User> queryByEntType(int entType) {
		List<User> listObj = new ArrayList<User>();
		try {
			List<Object> listObjects = userService.query(user, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof User) {
					listObj.add((User) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String login() {
		List<User> list = queryByEntType(4);
		loginFlag = "账号或密码错误！";
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		if (list != null && !list.isEmpty()) {
			// 登录成功
			user = list.get(0);
			int user_type = user.getUser_type();
			if (user_type == 1) {
				// 学生页面
				session.put("current_user", user);
				return "stu_page";
			} else if (user_type == 2) {
				// 去member表中查找，确实该用户是否是真的社长。
				// 如果是，则进入页面；如果不是，则修改user的user_type为1
				member = new Member();
				member.setUser_id(user.getId());
				List<Object> member_list = memberService.query(member, 2);
				if (member_list != null && !member_list.isEmpty()) {
					member = (Member) member_list.get(0);
					if (2 == member.getMember_type()) {
						session.put("current_member", member);
						session.put("current_user", user);
						return "cmnt_page";
					} else {
						user.setUser_type(1);
						userService.update(user);
					}
				}
				// 社长页面
				return "login";
			} else if (user_type == 3) {
				// 管理员页面
				return "admin_page";
			}
		}
		return "login";
	}
	
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("current_member");
		return "logout";
	}
	
	
	
	
	
	
	
}
