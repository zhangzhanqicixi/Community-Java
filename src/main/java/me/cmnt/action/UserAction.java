package me.cmnt.action;

import java.util.List;

import javax.swing.ListModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "user")
@Namespace("/")
public class UserAction {

	@Autowired
	private BaseServiceI userService;
	private List<User> userList;
	private String uid;
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
	public void queryByEntType(int entType) {
		User user = new User();
		switch (entType) {
			case 1: user.setId(Integer.valueOf(uid)); break;
			default: break;
		}
		List<Object> listObjects = userService.query(user, entType);
		for (Object user_temp : listObjects) {
			if (user_temp instanceof User) {
				userList.add((User) user_temp);
			}
		}
	}
	
	
	
}
