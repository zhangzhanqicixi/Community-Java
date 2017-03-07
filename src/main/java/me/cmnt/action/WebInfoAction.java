package me.cmnt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.WebInfo;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webInfo")
@Namespace("/")

public class WebInfoAction {
	@Autowired
	private BaseServiceI webInfoService;
	private List<WebInfo> webInfoList;
	private String uid;

	public List<WebInfo> getWebInfoList() {
		return webInfoList;
	}
	public void setWebInfoList(List<WebInfo> webInfoList) {
		this.webInfoList = webInfoList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public void queryByEntType(int entType) {
		WebInfo webInfo = new WebInfo();
		switch (entType) {
			case 1: webInfo.setId(Integer.valueOf(uid)); break;
			default: break;
		}
		List<Object> listObjects = webInfoService.query(webInfo, entType);
		for (Object winfo : listObjects) {
			if (winfo instanceof WebInfo) {
				webInfoList.add((WebInfo)winfo);
			}
		}
	}
}
