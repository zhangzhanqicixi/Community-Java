package me.cmnt.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;
import me.cmnt.service.UserServiceI;

@ParentPackage("basePackage")
@Action(value = "strust2Test") // 使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action，Action的名字为struts2Test
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class TestAction {
	
	/**
	 * 注入userService，先按类型，后按变量名
	 */
	@Autowired
	private BaseServiceI userService;
	
	/**
     * http://localhost:8080/community/strust2Test!saveUser.action
     */
    public void saveUser(){
        User user = new User();
        user.setUsername("zzq32432423");
        user.setPassword("dasdasdas");
        userService.save(user);
    }
}
