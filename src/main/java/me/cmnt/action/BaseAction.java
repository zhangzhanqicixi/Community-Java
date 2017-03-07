package me.cmnt.action;

import java.util.List;

import me.cmnt.model.Community;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("basePackage")
public abstract class BaseAction 	extends ActionSupport  {
	
	/**
	 * 按条件查找，默认0位查找全部，1位按主键id查找
	 * @param entType
	 */
	public abstract List queryByEntType(int entType);
	
	private String message = null;
	private int statusCode = 200;
	protected static final String OPERATION_DONE = "operationDone";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	private String ajaxForward(int statusCode) {
		this.statusCode = statusCode;
		return OPERATION_DONE;
	}
	protected String ajaxForwardSuccess(String message) {
		this.message = message;
		return ajaxForward(200);
	}
	protected String ajaxForwardError(String message) {
		this.message = message;
		return ajaxForward(300);
	}
	
	
}
