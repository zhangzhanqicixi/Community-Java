package me.cmnt.action;

import java.util.List;

import me.cmnt.model.Activity;
import me.cmnt.model.Community;
import me.cmnt.model.WebInfo;
import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("basePackage")
@Action(value = "ajax")
@Namespace("/")
@Results({
	@Result(name = "json", type = "json"),
})
public class AjaxAction extends BaseAction {
	private String msgAct;
	private String msgNews;
	private String msgIntro;
	private String msgCmnt;
	@Autowired
	private BaseServiceI activityService;
	@Autowired
	private BaseServiceI webNewsService;
	@Autowired
	private BaseServiceI webInfoService;
	@Autowired
	private BaseServiceI communityService;
	public String getMsgAct() {
		return msgAct;
	}
	public void setMsgAct(String msgAct) {
		this.msgAct = msgAct;
	}
	public String getMsgNews() {
		return msgNews;
	}
	public void setMsgNews(String msgNews) {
		this.msgNews = msgNews;
	}
	public String getMsgIntro() {
		return msgIntro;
	}
	public void setMsgIntro(String msgIntro) {
		this.msgIntro = msgIntro;
	}
	public String getMsgCmnt() {
		return msgCmnt;
	}
	public void setMsgCmnt(String msgCmnt) {
		this.msgCmnt = msgCmnt;
	}
	
	/**
	 * 获得全部新闻
	 * @return
	 */
	public String getAllNews() {
		List list = webNewsService.query(new WebNews(), 0);
		if (list != null) {
			msgNews = list.toString();
		}
		return "json";
	}
	
	/**
	 * 获得全部社团活动
	 * @return
	 */
	public String getAllActivity() {
		List list = activityService.query(new Activity(), 0);
		if (list != null) {
			msgAct = list.toString();
		}
		return "json";
	}
	
	/**
	 * 获得全部社团
	 * @return
	 */
	public String getCommunity() {
		List list = communityService.query(new Community(), 0);
		if (list != null) {
			msgCmnt = list.toString();
		}
		return "json";
	}
	
	
	@SuppressWarnings("finally")
	public String homepageInfo() {
		try {
			pre10Activity();
			pre10News();
			pre2Community();
			getContact();
		} finally {
			return "json";
		}
	}
	
	/**
	 * 获得前10条新闻
	 * @return
	 */
	public void pre10News() {
		List list = webNewsService.query(new WebNews(), 3);
		if (list != null) {
			msgNews = list.toString();
		}
	}
	
	/**
	 * 获得前10条社团活动
	 * @return
	 */
	public void pre10Activity() {
		List list = activityService.query(new Activity(), 3);
		if (list != null) {
			msgAct = list.toString();
		}
	}
	
	/**
	 * 获得网站介绍 - 联系我们
	 * @return
	 */
	public void getContact() {
		msgIntro = webInfoService.query(new WebInfo(), 0).get(0).toString();
	}
	
	/**
	 * 获得前两家社团
	 * @return
	 */
	public void pre2Community() {
		List list = communityService.query(new Community(), 3);
		if (list != null) {
			msgCmnt = list.toString();
		}
	}
	
	@Override
	public List queryByEntType(int entType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
