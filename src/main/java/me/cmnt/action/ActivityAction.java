package me.cmnt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.cmnt.model.Activity;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage") // 用package来组织action
@Action(value = "activity")
@Namespace("/")
public class ActivityAction {
	
	@Autowired
	private BaseServiceI activityService;
	private List<Activity> activityList;
	private String uid;
	
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
	
	/**
	 * 根据条件查找，并赋值到activityList
	 * @param entType
	 */
	public void queryByEntType(int entType) {
		Activity activity = new Activity();
		switch (entType) {
			case 1: activity.setId(entType); break;
			default: break;
		}
		List<Object> listObject = activityService.query(activity, entType);
		for (Object acty : listObject) {
			if (acty instanceof Activity) {
				activityList.add((Activity) acty);
			}
		}
	}
}
