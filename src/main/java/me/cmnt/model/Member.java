package me.cmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "community_member", schema = "community")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "community_id")
	private int community_id;
	@Column(name = "member_status")
	private int member_status;
	@Column(name = "member_type")
	private int member_type;
	@Column(name = "member_apply_reason")
	private String member_apply_reason;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}
	public int getMember_type() {
		return member_type;
	}
	public void setMember_type(int member_type) {
		this.member_type = member_type;
	}
	public String getMember_apply_reason() {
		return member_apply_reason;
	}
	public void setMember_apply_reason(String member_apply_reason) {
		this.member_apply_reason = member_apply_reason;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"user_id\":\"" + user_id
				+ "\",\"community_id\":\"" + community_id
				+ "\",\"member_status\":\"" + member_status
				+ "\",\"member_type\":\"" + member_type
				+ "\",\"member_apply_reason\":\"" + member_apply_reason
				+ "\"}";
	}
	
}
