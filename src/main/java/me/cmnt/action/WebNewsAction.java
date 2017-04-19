package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.WebMsg;
import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webNews")
@Namespace("/")
@Results({ 
		@Result(name = "news_list", location = "/jsp/main_page/news.jsp"),
})
public class WebNewsAction extends BaseAction {

	@Autowired
	private BaseServiceI webNewsService;
	private List<WebNews> webNewsList;
	private String uid;
	private WebNews webNews;
	private String msg;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public List<WebNews> queryByEntType(int entType) {
		List<WebNews> listObj = new ArrayList<WebNews>();
		try {
			if (webNews == null) {
				webNews = new WebNews();
			}
			List<Object> listObjects = webNewsService.query(webNews, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof WebNews) {
					listObj.add((WebNews) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;
		}
	}

	public String save() {
		if (webNews != null) {
			webNewsService.save(webNews);
			return ajaxForwardSuccess("保存成功");
		}
		return ajaxForwardError("保存失败!");
	}

	public String news_list() {
		webNewsList = queryByEntType(0);
		return "news_list";
	}
}
