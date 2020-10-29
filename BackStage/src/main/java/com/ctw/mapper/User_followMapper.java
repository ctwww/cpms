package com.ctw.mapper;

import java.util.List;

import com.ctw.bean.User_follow;

public interface User_followMapper {

	public List<User_follow> selectAUser_followList(String id);

	public User_follow selectAUser_follow(User_follow user_follow);

	public void deleteAUser_follow(User_follow user_follow);

	public void insertAUser_follow(User_follow u);

	public List<User_follow> selectAUser_followListByLink(String link);

}
