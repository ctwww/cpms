package com.ctw.bean;

import java.util.Date;

public class Access_statistics {

	private Date date;
	private String link;
	private Integer sum;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	@Override
	public String toString() {
		return "Access_statistics [date=" + date + ", link=" + link + ", sum=" + sum + "]";
	}
	
	
}
