package com.ctw.service;

import java.util.List;

import com.ctw.bean.User;

public interface UserService {

	public String adminlogin(String username, String password);
	
	public List<User> getAllUser();
	
	public String Userlist2Json(List<User> list);
	
	public String updateUser(User u);

	public String deleteUserById(String id);

	public String addAUser(User u);

	public String getUsernameById(String id);

	public String checkId(User u);

	public List<User> getAUserById(User u);

	public String updateUserWechat_id(User u);
	
}
