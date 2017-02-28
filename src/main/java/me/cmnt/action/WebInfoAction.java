package me.cmnt.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webInfo")
@Namespace("/")
public class WebInfoAction {
	@Autowired
	private BaseServiceI webInfoService;
}
