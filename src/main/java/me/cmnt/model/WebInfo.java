package me.cmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "community_web_info", schema = "community")
public class WebInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	@Column(name="introduction")
	private String introduction;
	@Column(name="contact_us")
	private String contact_us;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContact_us() {
		return contact_us;
	}
	public void setContact_us(String contact_us) {
		this.contact_us = contact_us;
	}
}
