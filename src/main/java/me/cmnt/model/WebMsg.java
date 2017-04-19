package me.cmnt.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "community_web_message", schema = "community")
public class WebMsg {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="content")
	private String content;
	@Column(name="news_id")
	private int news_id;
	@Column(name="insert_time")
	private String insert_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"user_id\":\"" + user_id
				+ "\",\"content\":\"" + content + "\",\"news_id\":\"" + news_id
				+ "\",\"insert_time\":\"" + insert_time + "\"}";
	}
}
