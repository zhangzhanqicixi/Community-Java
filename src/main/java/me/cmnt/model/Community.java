package me.cmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "community", schema = "community")
public class Community {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	@Column(name = "community_name")
	private String community_name;
	@Column(name = "community_introduction")
	private String community_introduction;
	@Column(name = "community_img_path")
	private String community_img_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommunity_introduction() {
		return community_introduction;
	}
	public void setCommunity_introduction(String community_introduction) {
		this.community_introduction = community_introduction;
	}
	public String getCommunity_img_path() {
		return community_img_path;
	}
	public void setCommunity_img_path(String community_img_path) {
		this.community_img_path = community_img_path;
	}
	
	public String getCommunity_name() {
		return community_name;
	}
	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}
	@Override
	public String toString() {
		return "Community [id=" + id + ", community_name=" + community_name
				+ ", community_introduction=" + community_introduction
				+ ", community_img_path=" + community_img_path + "]";
	}
	
	

}
