package com.ctw.bean;

import java.util.Date;

public class Journal {

	private String id;
	private Date date;
	private String illustrate;
	private String type;
	private String operation;//Ôö¼Ó¡¢ÐÞ¸Ä¡¢É¾³ý
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIllustrate() {
		return illustrate;
	}
	public void setIllustrate(String illustrate) {
		this.illustrate = illustrate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
		return "Journal [id=" + id + ", date=" + date + ", illustrate=" + illustrate + ", type=" + type + ", operation="
				+ operation + "]";
	}
	
}
