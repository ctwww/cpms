package com.ctw.bean;

public class User_follow {

	private String id;
	private String link;
	private String follow_remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFollow_remarks() {
		return follow_remarks;
	}
	public void setFollow_remarks(String follow_remarks) {
		this.follow_remarks = follow_remarks;
	}
	@Override
	public String toString() {
		return "User_follow [id=" + id + ", link=" + link + ", follow_remarks=" + follow_remarks + "]";
	}

	
}
