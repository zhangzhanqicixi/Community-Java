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
	@Column(name="tel")
	private String tel;
	@Column(name="addres")
	private String addres;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"introduction\":\"" + introduction
				+ "\",\"tel\":\"" + tel + "\",\"addres\":\"" + addres + "\"}";
	}
}
