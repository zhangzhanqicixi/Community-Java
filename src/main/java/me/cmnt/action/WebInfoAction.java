package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.xml.internal.rngom.parse.host.Base;

import me.cmnt.model.WebInfo;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webInfo")
@Namespace("/")
@Results({
	@Result(name = "webInfo", location = "/jsp/common/web/info_edit.jsp")
})
public class WebInfoAction extends BaseAction {
	@Autowired
	private BaseServiceI webInfoService;
	private List<WebInfo> webInfoList;
	private String uid;
	private WebInfo webInfo;

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
	public WebInfo getWebInfo() {
		return webInfo;
	}
	public void setWebInfo(WebInfo webInfo) {
		this.webInfo = webInfo;
	}
	
	@Override
	public List<WebInfo> queryByEntType(int entType) {
		try {
			List<WebInfo> listObj = new ArrayList<WebInfo>();
			if (webInfo == null) {
				webInfo = new WebInfo();
			}
			List<Object> listObjects = webInfoService.query(webInfo, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof WebInfo) {
					listObj.add((WebInfo) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;		
		}
	}
	
	public String select_info() {
		List<WebInfo> list = queryByEntType(0);
		if (list == null || list.isEmpty()) {
			return ajaxForwardError("当前没有网站介绍信息，请去数据库添加");
		}
		webInfo = list.get(0);
		return "webInfo";
	}
	
	public String saveOrUpdate() {
		if (webInfo == null) {
			return ajaxForwardError("操作失败");
		}
		try {
			if (webInfo.getId() > 0) {
				// update
				webInfoService.update(webInfo);
			} else {
				// insert
				webInfoService.save(webInfo);
			}
			return ajaxForwardSuccess("操作成功！");
		} catch (Exception e) {
			return ajaxForwardError("操作失败！");
		}
		
	}
	

	
}
