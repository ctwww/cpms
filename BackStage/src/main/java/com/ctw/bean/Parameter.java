package com.ctw.bean;

public class Parameter {

	private String link;
	private String parameter;
	private String remarks;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Parameter [link=" + link + ", parameter=" + parameter + ", remarks=" + remarks + "]";
	}
	
	
}
