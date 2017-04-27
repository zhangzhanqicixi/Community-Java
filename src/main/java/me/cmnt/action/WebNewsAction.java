package me.cmnt.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.fabric.xmlrpc.base.Params;

import me.cmnt.model.WebMsg;
import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;
import me.cmnt.util.Util;

@ParentPackage("basePackage")
@Action(value = "webNews")
@Namespace("/")
@InterceptorRefs(value = {
		@InterceptorRef(value = "fileUpload", params = {
				"maximumSize", "209715200",
				"allowedExtensions", ".jpg"
		}),
		@InterceptorRef(value = "defaultStack")
})
@Results({ 
		@Result(name = "news_list", location = "/jsp/main_page/news.jsp"),
		@Result(name = "news_details", location = "/homepage/shownews.jsp") 
})
public class WebNewsAction extends BaseAction {

	private static final int BUFFER_SIZE = 16 * 1024;

	@Autowired
	private BaseServiceI webNewsService;
	private List<WebNews> webNewsList;
	private String uid;
	private String msg;
	private WebNews webNews;
	// 封装上传文件域的属性
	private File file;
	private String fileFileName;
	private String fileContentType;

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

	/**
	 * 保存新闻
	 * 
	 * @return
	 */
	public String save() {
		try {
			if (webNews != null) {
				if (file != null) {
					 String destString = ServletActionContext
					 .getServletContext().getRealPath("/news_upload")
					 + "/" + fileFileName;
					 FileUtils.copyFile(file, new File(destString));
					 webNews.setNews_img_path("news_upload/" + fileFileName);
				}
				webNews.setInsert_time(Util.getCurrentTime());
				webNewsService.save(webNews);
				return ajaxForwardSuccess("保存成功");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return ajaxForwardError("保存失败!");
	}

	public String news_list() {
		webNewsList = queryByEntType(0);
		return "news_list";
	}

	public String getNewsDetails() {
		webNews = new WebNews();
		webNews.setId(Integer.valueOf(uid));
		webNews = queryByEntType(1).get(0);
		return "news_details";
	}
}
