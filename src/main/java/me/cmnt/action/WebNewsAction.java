package me.cmnt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webNews")
@Namespace("/")
public class WebNewsAction {
	
	@Autowired
	private BaseServiceI webNewsService;
	private List<WebNews> webNewsList;
	private String uid;
	public List<WebNews> getWebNewsList() {
		return webNewsList;
	}
	public void setWebNewsList(List<WebNews> webNewsList) {
		this.webNewsList = webNewsList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void queryByEntType(int entType) {
		WebNews webNews = new WebNews();
		switch (entType) {
			case 1: webNews.setId(Integer.valueOf(uid)); break;
			default: break;
		}
		List<Object> listObjects = webNewsService.query(webNews, entType);
		for (Object webNewsObject : listObjects) {
			if (webNewsObject instanceof WebNews) {
				webNewsList.add((WebNews)webNewsObject);
			}
		}
	}
}
