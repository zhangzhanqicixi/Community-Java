package me.cmnt.action;

import java.util.List;

import javax.swing.ListModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.xml.internal.rngom.parse.host.Base;

import me.cmnt.model.Member;
import me.cmnt.service.BaseServiceI;

@ParentPackage("basePackage")
@Action(value = "member")
@Namespace("/")
public class MemberAction {
	
	@Autowired
	private BaseServiceI memberService;
	private List<Member> memberList;
	private String uid;
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public void queryByEntType(int entType) {
		Member member = new Member();
		switch (entType) {
			case 1: member.setId(Integer.valueOf(uid)); break;
			default: break;
		}
		List<Object> listObjects = memberService.query(member, entType);
		for (Object mber : listObjects) {
			if (mber instanceof Member) {
				memberList.add((Member)mber);
			}
		}
	}
	
}
