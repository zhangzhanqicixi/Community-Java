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

import me.cmnt.model.Activity;
import me.cmnt.model.Member;
import me.cmnt.model.User;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage") // 用package来组织action
@Action(value = "activity")
@Namespace("/")
@Results({
	@Result(name = "list_act", location="/jsp/common/activity/activity.jsp"),
	@Result(name = "doUpdate", location="/jsp/common/activity/update.jsp")
})
public class ActivityAction extends BaseAction {
	
	@Autowired
	private BaseServiceI activityService;
	private List<Activity> activityList;
	private String uid;
	private String community_id;
	private Activity activity;
	private User user;
	private Member member;
	public List<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(String community_id) {
		this.community_id = community_id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public List<Activity> queryByEntType(int entType) {
		List<Activity> listObj = new ArrayList<Activity>();
		try {
			if (activity == null) {
				activity = new Activity();
			}
			List<Object> listObjects = activityService.query(activity, entType);
			for (Object cmnt : listObjects) {
				if (cmnt != null && cmnt instanceof Activity) {
					listObj.add((Activity) cmnt);
				}
			}
			return listObj;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获得所有活动
	 * @return
	 */
	public String list_activity() {
		if (community_id != null && !community_id.isEmpty()) {
			activity = new Activity();
			activity.setCommunity_id(Integer.valueOf(community_id));
			activityList = queryByEntType(2);
		}
		return "list_act";
	}
	
	public String getActByUid() {
		activity = new Activity();
		activity.setId(Integer.valueOf(uid));
		List<Activity> listObj = queryByEntType(1);
		if (listObj == null && listObj.isEmpty()) {
			return ajaxForwardError("没有该活动信息！");
		}
		activity = listObj.get(0);
		return "doUpdate";
	}
	
	/**
	 * 保存或更新活动
	 * @return
	 */
	public String saveOrUpdate() {
		try {
		
			if (activity.getId() == 9999) {
				// insert
				ActionContext actionContext = ActionContext.getContext();	//获得Struts容器
				Map<String,Object> session = actionContext.getSession();	//获得Session容器
				member = (Member) session.get("current_member");
				activity.setCommunity_id(member.getCommunity_id());
				activityService.save(activity);
				return ajaxForwardSuccess("保存成功！");
			} else {
				// update
				activityService.update(activity);
				return ajaxForwardSuccess("更新成功！");
			}
		} catch (Exception e) {
			return ajaxForwardError("操作失败，请重试！");
		}
	}
	
	/**
	 * 删除活动
	 * @return
	 */
	public String delete() {
		try {
			activity = new Activity();
			activity.setId(Integer.valueOf(uid));
			activityService.delete(activity);
			return ajaxForwardSuccess("删除成功！");
		} catch (Exception e) {
			return ajaxForwardError("删除失败！");
		}
	}
}
