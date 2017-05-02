package me.cmnt.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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
	@Result(name = "stu_page", location = "/homepage/index.jsp", type="redirect"),
	@Result(name = "cmnt_page", location = "/WEB-INF/cmnt_admin.jsp"), 
	@Result(name = "admin_page", location = "/WEB-INF/admin.jsp"),
	@Result(name = "logout", location= "/mogin.jsp"),
	@Result(name = "homepage_logout", location = "/homepage/index.jsp", type="redirect"),
	@Result(name = "login", location="/login.jsp"),
	@Result(name = "saveImage", location = "/homepage/user_info.jsp", type="redirect")
	
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
	// 封装上传文件域的属性
	private File file;
	private String fileFileName;
	private String fileContentType;
	private final static String USER_COOKIE = "USER_COOKIE";
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
	
	public String saveImage() {
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		User user = (User) session.get("user");
		if (file != null) {
			String destString = ServletActionContext
					 .getServletContext().getRealPath("/user_upload")
					 + "/" + fileFileName;
					 try {
						FileUtils.copyFile(file, new File(destString));
					} catch (IOException e) {
						e.printStackTrace();
					}
			user.setUser_img("user_upload/" + fileFileName);
			userService.update(user);
		}
		return "saveImage";
	}
	
	/**
	 * 主页登录
	 * @return
	 */
	public String homepage_login() {
		flag = "账号或密码错误！";
		List<User> list = queryByEntType(4);
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		if (list != null && !list.isEmpty()) {
			// 登录成功 
			user = list.get(0);
			// 获得memeber对象
			/*
			Member member = new Member();
			member.setUser_id(user.getId());
			for (Object object : memberService.query(member, 2)) {
				if (object instanceof Member) {
					int member_type = ((Member) object).getMember_type();
					if (member_type == 1) {
						// 学生
						member = (Member) object;
					}
				}
			}*/
			session.put("user", user);
			// 类型判断
			Cookie cookie = new Cookie(USER_COOKIE, user.getUsername() + "," + user.getPassword());
			cookie.setMaxAge(60 * 60 * 24 * 1); // 保存时间为1天
			ServletActionContext.getResponse().addCookie(cookie);
			return "stu_page";
		}
		return "login";
	}
	
	/**
	 * 主页登出
	 * @return
	 */
	public String homepage_logout() {
		// 删除session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		//清除登陆页面缓存  
		response.setHeader("Pragma","No-cache");   
		response.setHeader("Cache-Control","no-cache");  
		response.setHeader("Cache-Control", "no-store");  
		response.setDateHeader("Expires", 0); 
		// 删除cookie (置空）
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie each : cookies) {
				if (USER_COOKIE.equals(each.getName())) {
					Cookie cookie = new Cookie(USER_COOKIE, "");
					cookie.setMaxAge(0);
					ServletActionContext.getResponse().addCookie(cookie);
				}
			}
		}
		return "homepage_logout";
	}
	
	/**
	 * 后台登录
	 * @return
	 */
	public String login() {
		List<User> list = queryByEntType(4);
		loginFlag = "账号或密码错误！";
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		if (list != null && !list.isEmpty()) {
			// 登录成功 
			user = list.get(0);
			// 获得memeber对象
			Member member = new Member();
			member.setUser_id(user.getId());
			for(Object object : memberService.query(member, 2)) {
				if (object instanceof Member) {
					int member_type = ((Member) object).getMember_type();
					if (member_type == 3) {
						// 管理员
						member = (Member) object;
						break;
					} else if (member_type == 2) {
						// 社长
						if (member_type != 3) {
							member = (Member) object;
							break;
						}
					}
				}
			}
			if (member != null && member.getId() != 0) {
				session.put("member", member);
				session.put("user", user);
				int member_type = member.getMember_type();
				// 类型判断
				if (member_type == 3) {
					return "admin_page";
				} else if (member_type == 2) {
					return "cmnt_page";
				}
			}
		}
		return "login";
	}
	
	/**
	 * 账号注册
	 * @return
	 */
	public String register() {
		if (user != null) {
			// 1. 判断该用户是否已存在
			List<Object> listobj = userService.query(user, 2);
			if(listobj != null && !listobj.isEmpty()) {
				flag = "该用户名已存在!";
				return "login";
			}
			// 2. 判断该学号是否已存在
			listobj = userService.query(user, 5);
			if(listobj != null && !listobj.isEmpty()) {
				flag = "该学号已存在!";
				return "login";
			}
			userService.save(user);
			Member member = new Member();
			member.setUser_id(user.getId());
			member.setCommunity_id(0);
			member.setMember_type(1);
			member.setMember_status(0);
			memberService.save(member);
			flag = "注册成功！";
			return "login";
		}
		loginFlag = "注册失败！请重试";
		return "login";
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String logout() {
		// 删除session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("member");
		session.remove("user");
		// 删除cookie (置空）
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie each : cookies) {
				if ("user.cookie".equals(each.getName())) {
					Cookie cookie = new Cookie("USER_COOKIE", "");
					cookie.setMaxAge(0);
					ServletActionContext.getResponse().addCookie(cookie);
				}
			}
		}
		return "logout";
	}
	
	
	
	
	
	
	
}
