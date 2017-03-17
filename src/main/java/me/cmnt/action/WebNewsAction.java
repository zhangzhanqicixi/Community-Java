package me.cmnt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webNews")
@Namespace("/")
public class WebNewsAction extends BaseAction {
	
	@Autowired
	private BaseServiceI webNewsService;
	private List<WebNews> webNewsList;
	private String uid;
	private WebNews webNews;
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
	public WebNews getWebNews() {
		return webNews;
	}
	public void setWebNews(WebNews webNews) {
		this.webNews = webNews;
	}
	
	@Override
	public List queryByEntType(int entType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String save() {
		webNewsService.save(webNews);
		return ajaxForwardSuccess("保存成功");
	}
}
