package com.ctw.bean;

import java.util.Date;

public class Test {

	private String id;
	private String title;
	private String content;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	
	
}
