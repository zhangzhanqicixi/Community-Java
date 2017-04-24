package me.cmnt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "community_web_news", schema = "community")
public class WebNews {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	@Column(name="news_title")
	private String news_title;
	@Column(name="news_content")
	private String news_content;
	@Column(name="user_id")
	private int user_id;
	@Column(name="insert_time")
	private String insert_time;
	@Column(name="news_img_path")
	private String news_img_path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	public String getNews_img_path() {
		return news_img_path;
	}
	public void setNews_img_path(String news_img_path) {
		this.news_img_path = news_img_path;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"news_title\":\"" + news_title
				+ "\",\"news_content\":\"" + news_content + "\",\"user_id\":\""
				+ user_id + "\",\"insert_time\":\"" + insert_time
				+ "\",\"news_img_path\":\"" + news_img_path + "\"}";
	}
	
}
