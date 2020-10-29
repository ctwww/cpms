package com.ctw.mapper;

import java.util.List;

import com.ctw.bean.User;

public interface UserMapper {

	public User selectUserById(String id);
	
	public List<User> selectAllUser();
	
	public void insertUser(User user);
	
	public void updateUser(User user);

	public void deleteUserById(String id);

	public void updateUserWechat_idById(User u);
	
	
}
