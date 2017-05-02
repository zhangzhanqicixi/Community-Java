  package me.cmnt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.cmnt.model.Activity;
import me.cmnt.model.Community;
import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.model.WebInfo;
import me.cmnt.model.WebMsg;
import me.cmnt.model.WebNews;
import me.cmnt.service.BaseServiceI;
import me.cmnt.util.Util;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("basePackage")
@Action(value = "ajax")
@Namespace("/")
@Results({
	//params={"includeProperties", "msgIntro, msgNews, msgAct, msgCmnt, uid"}
	@Result(name = "json", type = "json"),
	@Result(name = "json_info", type= "json", params = {"includeProperties", "msgAct, msgNews, msgIntro, msgCmnt"}),
	@Result(name = "json_comment", type= "json", params = {"includeProperties", "newsComment, newsCommentUser"}),
	@Result(name = "json_cmnt", type = "json", params = {"includeProperties", "msgCmnt"}),
	@Result(name = "json_cmnt_details", type = "json", params = {"includeProperties", "cmntSingle, msgUser"}),
	@Result(name = "json_news", type = "json", params = {"includeProperties", "msgNews"}),
	@Result(name = "json_acts", type = "json", params = {"includeProperties", "msgAct, msgActCmnt"}),
	@Result(name = "json_act", type = "json", params = {"includeProperties", "msgAct, msgActCmnt"}),
	@Result(name = "json_member", type = "json", params = {"includeProperties", "msgMember"}),
	@Result(name = "json_user_info", type = "json", params = {"includeProperties", "msgUser, msgCmnt"}),
	@Result(name = "json_about_info", type = "json", params = {"includeProperties", "msgWebInfo"})
})
public class AjaxAction extends BaseAction {
	private String msgAct;
	private String msgNews;
	private String msgIntro;
	private String msgCmnt;
	private String msgActCmnt;
	private String msgUser;
	private String msgMember;
	private String webNews;
	private String msgWebInfo;
	private String newsComment;
	private String newsCommentUser;
	private String cmntSingle;
	private String uid;
	private String username;
	private String content;
	@Autowired
	private BaseServiceI activityService;
	@Autowired
	private BaseServiceI webNewsService;
	@Autowired
	private BaseServiceI webInfoService;
	@Autowired
	private BaseServiceI communityService;
	@Autowired
	private BaseServiceI userService;
	@Autowired
	private BaseServiceI webMsgService;
	@Autowired
	private BaseServiceI memberService;
	
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
	public String getMsgActCmnt() {
		return msgActCmnt;
	}
	public void setMsgActCmnt(String msgActCmnt) {
		this.msgActCmnt = msgActCmnt;
	}
	public String getWebNews() {
		return webNews;
	}
	public void setWebNews(String webNews) {
		this.webNews = webNews;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNewsComment() {
		return newsComment;
	}
	public void setNewsComment(String newsComment) {
		this.newsComment = newsComment;
	}
	public String getNewsCommentUser() {
		return newsCommentUser;
	}
	public void setNewsCommentUser(String newsCommentUser) {
		this.newsCommentUser = newsCommentUser;
	}
	public String getMsgUser() {
		return msgUser;
	}
	public void setMsgUser(String msgUser) {
		this.msgUser = msgUser;
	}
	public String getCmntSingle() {
		return cmntSingle;
	}
	public void setCmntSingle(String cmntSingle) {
		this.cmntSingle = cmntSingle;
	}
	public String getMsgMember() {
		return msgMember;
	}
	public void setMsgMember(String msgMember) {
		this.msgMember = msgMember;
	}
	public String getMsgWebInfo() {
		return msgWebInfo;
	}
	public void setMsgWebInfo(String msgWebInfo) {
		this.msgWebInfo = msgWebInfo;
	}
	
	/**
	 * 网站简介
	 * @return
	 */
	public String getAboutInfo() {
		WebInfo webInfo = new WebInfo();
		List list = webInfoService.query(webInfo, 0);
		webInfo = (WebInfo) list.get(0);
		msgWebInfo = webInfo.toString();
		return "json_about_info";
	}
	
	/**
	 * 用户信息
	 * @return
	 */
	public String user_info() {
		ActionContext actionContext = ActionContext.getContext(); // 获得Struts容器
		Map<String, Object> session = actionContext.getSession(); // 获得Session容器
		User user = (User) session.get("user");
		msgUser = user.toString();
		// 活动该用户的社团信息
		Member member = new Member();
		member.setUser_id(user.getId());
		member.setMember_status(1);
		member.setMember_type(1);
		List list = memberService.query(member, 9);
		List<Community> cmnt_list = new ArrayList<Community>();
		if (!list.isEmpty()) {
			for (Object object : list) {
				Member member_1 = (Member) object;
				if (member_1.getCommunity_id() != 0) {
					Community community = new Community();
					community.setId(member_1.getCommunity_id());
					List list_c = communityService.query(community, 1);
					if (list_c != null && !list_c.isEmpty()) {
						community = (Community) list_c.get(0);
						cmnt_list.add(community);
					}
				}
			}
		}
		msgCmnt = cmnt_list.toString();
		return "json_user_info";
	}
	
	/**
	 * 查找活动详情
	 * @return
	 */
	public String getActivityDetails() {
		Activity activity = new Activity();
		Community community = new Community();
		activity.setId(Integer.valueOf(uid));
		List list = activityService.query(activity, 1);
		if (list != null && !list.isEmpty()) {
			if (list.get(0) instanceof Activity) {
				activity = (Activity) list.get(0);
				try {
					int community_id = activity.getCommunity_id();
					community.setId(community_id);
					community = (Community) communityService.query(community, 1).get(0);
					if (0 == community.getId()) {
						community = null;
					}
				} catch (Exception e) {
					community = null;
				}
			}
			msgActCmnt = community.toString();
			msgAct = activity.toString();
		}
		return "json_act";
	}
	
	/**
	 * 判断该成员是否已加入该社团
	 * @return
	 */
	public String validateMember() {
		if (username != null && uid != null) {
			Member member = new Member();
			User user = new User();
			user.setUsername(username);
			List list = userService.query(user, 2);
			if (list != null && !list.isEmpty()) {
				user = (User) list.get(0);
				member.setUser_id(user.getId());
				member.setCommunity_id(Integer.valueOf(uid));
				List member_list = memberService.query(member, 6);
				if (member_list != null && !member_list.isEmpty()) {
					// 已存在该member
					member = (Member) member_list.get(0);
				} else {
					// 存储该成员的申请
					member.setMember_status(0);
					member.setMember_type(1);
					member.setMember_apply_reason(content);
					memberService.save(member);
					member = new Member();
				}
			}
			msgMember = member.toString();
		}
		return "json_member";
	}
	
	/**
	 * 查找某个社团详细信息
	 * @return
	 */
	public String getCommunityDetails() {
		Community community = new Community();
		community.setId(Integer.valueOf(uid));
		List list = communityService.query(community, 1);
		if (list != null && !list.isEmpty()) {
			community = (Community) list.get(0);
			cmntSingle = community.toString();
			// 去找社长
			Member member = new Member();
			member.setCommunity_id(community.getId());
			member.setMember_type(2);
			List list_member = memberService.query(member, 4);
			if (list_member != null && !list_member.isEmpty()) {
				member = (Member) list_member.get(0);
				User user = new User();
				user.setId(member.getUser_id());
				List list_user = userService.query(user, 1);
				user = (User) list_user.get(0);
				msgUser = user.toString();
			}
		}
		return "json_cmnt_details";
	}
	
	/**
	 * 查找所有社团
	 * @return
	 */
	public String getAllCommunity() {
		List list = communityService.query(new Community(), 0);
		if (list != null) {
			msgCmnt = list.toString().replace("\n", "\\n");
		}
		return "json_cmnt";
	}
	
	/**
	 * 保存评论
	 * @return
	 */
	public String saveComment() {
		// 获得该username的userid
		User user = new User();
		user.setUsername(username);
		List list = userService.query(user, 2);
		if (list != null) {
			user = (User) list.get(0);
			WebMsg webMsg = new WebMsg();
			webMsg.setUser_id(user.getId());
			webMsg.setContent(content);
			webMsg.setNews_id(Integer.valueOf(uid));
			webMsg.setInsert_time(Util.getCurrentTime());
			webMsgService.save(webMsg);
		}
		return "json";
	}
	
	/**
	 * 获得该条新闻的所有评论
	 * @return
	 */
	public String CommentByNews() {
		// 获得所有新闻
		WebMsg webMsg = new WebMsg();
		webMsg.setNews_id(Integer.valueOf(uid));
		List list = webMsgService.query(webMsg, 2);
		List<User> user_list = new ArrayList<User>();
		// 便利每条新闻，获得评论人信息
		if (list != null) {
			for (Object object : list) {
				if (object instanceof WebMsg) {
					WebMsg wm = (WebMsg) object;
					User user = new User();
					int user_id = wm.getUser_id();
					user.setId(user_id);
					user = (User) userService.query(user, 1).get(0);
					if (0 == user.getId()) {
						user = null;
					}
					user_list.add(user);
				}
			}
		}
		newsComment = list.toString();
		newsCommentUser = user_list.toString();
		return "json_comment";
	}
	
	
	/**
	 * 获得新闻详情内容
	 * @return
	 */
	public String getWebNewsDetails() {
		if (uid != null) {
			WebNews webNews_ = new WebNews();
			webNews_.setId(Integer.valueOf(uid));
			webNews = webNewsService.query(webNews_, 1).get(0).toString().replace("\n", "\\n");
		}
		return "json";
	}
	
	/**
	 * 获得全部新闻
	 * @return
	 */
	public String getAllNews() {
		List list = webNewsService.query(new WebNews(), 0);
		if (list != null) {
			msgNews = list.toString().replace("\n", "\\n");
		}
		return "json_news";
	}
	
	/**
	 * 获得全部社团活动
	 * @return
	 */
	@SuppressWarnings("null")
	public String getAllActivity() {
		List list = activityService.query(new Activity(), 0);
		List<Community> listCmnt = new ArrayList<Community>();
		if (list != null) {
			for (Object object : list) {
				if (object instanceof Activity) {
					Community community = new Community();
					try {
						int community_id = ((Activity) object).getCommunity_id();
						community.setId(community_id);
						community = (Community) communityService.query(community, 1).get(0);
						if (0 == community.getId()) {
							community = null;
						}
					} catch (Exception e) {
						community = null;
					}
					listCmnt.add(community);
				}
			}
			msgActCmnt = listCmnt.toString();
			msgAct = list.toString();
		}
		return "json_acts";
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
	
	/**
	 * 主页请求
	 * @return
	 */
	@SuppressWarnings("finally")
	public String homepageInfo() {
		try {
			pre10Activity();
			pre10News();
			pre2Community();
			getContact();
		} finally {
			return "json_info";
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
