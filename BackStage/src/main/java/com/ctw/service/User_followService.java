package com.ctw.service;

import java.util.List;

import com.ctw.bean.User_follow;

public interface User_followService {
	
	//��ȡĳ�û���ȫ����ע
	public List<User_follow> getAUser_followList(String id);

	public String User_followlist2Json(List<User_follow> list);

	public String deleteAFollow(User_follow u);

	public String addAUser_follow(User_follow u);

	public List<User_follow> getAUser_followListByLink(String link);
}
