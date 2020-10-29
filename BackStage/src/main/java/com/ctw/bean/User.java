package com.ctw.bean;

public class User {

	private String id;
	private String password;
	private String wechat_id;
	private Boolean isAdmin;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWechat_id() {
		return wechat_id;
	}
	public void setWechat_id(String wechat_id) {
		this.wechat_id = wechat_id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", wechat_id=" + wechat_id + ", isAdmin=" + isAdmin
				+ ", username=" + username + "]";
	}
	
}
