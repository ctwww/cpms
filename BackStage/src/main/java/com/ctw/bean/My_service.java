package com.ctw.bean;

public class My_service {

	private String ori_link;
	private String link_name;
	private String link;
	private String provider_name;
	private Boolean isPass;
	private String remarks;
	private String type;
	private String img;
	private Boolean isChecked;
	private Boolean has_parameter;
	
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public Boolean getIsPass() {
		return isPass;
	}
	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getOri_link() {
		return ori_link;
	}
	public void setOri_link(String ori_link) {
		this.ori_link = ori_link;
	}
	public Boolean getHas_parameter() {
		return has_parameter;
	}
	public void setHas_parameter(Boolean has_parameter) {
		this.has_parameter = has_parameter;
	}
	
	@Override
	public String toString() {
		return "My_service [ori_link=" + ori_link + ", link_name=" + link_name + ", link=" + link + ", provider_name="
				+ provider_name + ", isPass=" + isPass + ", remarks=" + remarks + ", type=" + type + ", img=" + img
				+ ", isChecked=" + isChecked + ", has_parameter=" + has_parameter + "]";
	}
	
	
}
