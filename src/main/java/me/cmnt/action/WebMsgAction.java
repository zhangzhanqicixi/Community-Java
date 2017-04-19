package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.model.WebMsg;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "webMsg")
@Namespace("/")
@Results({
	@Result(name = "message_list", location = "/jsp/main_page/webMessage.jsp"),
	@Result(name = "prepare_save", location = "/jsp/main_page/saveMsg.jsp"),
	@Result(name = "success", location = "/jsp/main_page/success.jsp"),
	@Result(name = "message_list_admin", location = "/jsp/common/web/chat_edit.jsp")
})
public class WebMsgAction extends BaseAction {
	
	@Autowired
	private BaseServiceI webMsgService;
	private List<WebMsg> webMsgList;
	private String uid;
	private String message;
	private WebMsg webMsg;
	private User user;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public WebMsg getWebMsg() {
		return webMsg;
	}
	public void setWebMsg(WebMsg webMsg) {
		this.webMsg = webMsg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public List<WebMsg> queryByEntType(int entType) {
		List<WebMsg> listObj = new ArrayList<WebMsg>();
		try {
			if (webMsg == null) {
				webMsg = new WebMsg();
			}
			List<Object> listObjects = webMsgService.query(webMsg, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof WebMsg) {
					listObj.add((WebMsg) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 留言列表
	 * @return
	 */
	public String chat_list() {
		webMsgList = queryByEntType(0);
		return "message_list";
	}
	
	/**
	 * 留言列表
	 * @return
	 */
	public String chat_list_admin() {
		webMsgList = queryByEntType(0);
		return "message_list_admin";
	}
	
	/**
	 * 准备存储留言
	 * @return
	 */
	public String save_chat() {
		ActionContext actionContext = ActionContext.getContext();	//获得Struts容器
		Map<String,Object> session = actionContext.getSession();	//获得Session容器
		user = (User) session.get("current_user");
		if (user != null) {
			webMsg = new WebMsg();
			return "prepare_save";
		}
		return null;
	}
	
	public String save() {
		webMsgService.save(webMsg);
		message = "保存成功！";
		return "success";
	}
	
	public String delete() {
		WebMsg webMsg = new WebMsg();
		webMsg.setId(Integer.valueOf(uid));
		webMsgService.delete(webMsg);
		return ajaxForwardSuccess("删除成功！");
	}
	
	
	
}
