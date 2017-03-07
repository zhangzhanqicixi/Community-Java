package me.cmnt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.WebMsg;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webMsg")
@Namespace("/")
public class WebMsgAction {
	
	@Autowired
	private BaseServiceI webMsgService;
	private List<WebMsg> webMsgList;
	private String uid;
	
	public List<WebMsg> getWebMsgList() {
		return webMsgList;
	}
	public void setWebMsgList(List<WebMsg> webMsgList) {
		this.webMsgList = webMsgList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public void queryByEntType(int entType) {
		WebMsg webMsg = new WebMsg();
		switch (entType) {
			case 1: webMsg.setId(Integer.valueOf(uid)); break;
			default: break;
		}
		List<Object> listObjects = webMsgService.query(webMsg, entType);
		for (Object webObject : listObjects) {
			if (webObject instanceof WebMsg) {
				webMsgList.add((WebMsg)webObject);
			}
		}
	}
}
