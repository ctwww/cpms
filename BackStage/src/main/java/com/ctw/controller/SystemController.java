package com.ctw.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctw.bean.My_service;
import com.ctw.bean.User;
import com.ctw.bean.User_follow;
import com.ctw.service.UserService;
import com.ctw.service.User_followService;

@Controller
public class SystemController {

	@Autowired(required = true)
	private UserService userService;
	@Autowired(required = true)
	private User_followService user_followService;
	
	//ԭ�ǽ�����Ա��¼����������ͨ�û���web��¼
	@RequestMapping(value = "/adminlogin",produces={"text/html;charset=UTF-8;","application/json;"})//produces��֤����ȥ������Ϊutf-8��ʽ
	@ResponseBody//���ص����ַ��������ǽ������ת
	public String adminlogin(User u, Model model,HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("user = " + u);
		String result = userService.adminlogin(u.getId(), u.getPassword());
		return result;
	}
	
	@RequestMapping(value = "/getusernamebyid",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getUsernameById(User u, Model model){
		System.out.println("user = " + u);
		String result = userService.getUsernameById(u.getId());
		return result;
	}
	
	@RequestMapping(value = "/getAUser",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getAUser(User u){
		System.out.println("user = " + u);
		List<User> result = userService.getAUserById(u);
		if(result == null){
			return "�û���Ϣ�޷���ѯ��";
		}else{
			System.out.println(userService.Userlist2Json(result));
			return userService.Userlist2Json(result);
		}
	}
	
	@RequestMapping(value = "/showUserList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showUserList(Model model){
		System.out.println("showUserList");
		List<User> list = userService.getAllUser();
		System.out.println(userService.Userlist2Json(list));
		return userService.Userlist2Json(list);
	}
	
	@RequestMapping(value = "/updateUser",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateUser(User u, Model model){
		System.out.println("user = " + u);
		String result = userService.updateUser(u);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/deleteUserById",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteUserByUsername(User u){
		System.out.println("user = " + u);
		return userService.deleteUserById(u.getId());
	}
	
	@RequestMapping(value = "/addAUser",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAUser(User u){
		System.out.println("user = " + u);
		return userService.addAUser(u);
	}
	
	//����id��ȡid�Ĺ�ע�б�
	@RequestMapping(value = "/getAUserFollow",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getAUserFollow(User u){
		String id = u.getId();
		System.out.println(id);
		List<User_follow> list = user_followService.getAUser_followList(id);
		System.out.println(user_followService.User_followlist2Json(list));
		return user_followService.User_followlist2Json(list);
	}
	
	//����link��ȡlink�Ĺ�ע�б�
	@RequestMapping(value = "/getAServiceFollow",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getAServiceFollow(My_service u){
		String link = u.getLink();
		System.out.println(link);
		List<User_follow> list = user_followService.getAUser_followListByLink(link);
		System.out.println(user_followService.User_followlist2Json(list));
		return user_followService.User_followlist2Json(list);
	}
	
	@RequestMapping(value = "/deleteAFollow",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAFollow(User_follow u){
		System.out.println("userfollow = " + u);
		return user_followService.deleteAFollow(u);
	}
	
	@RequestMapping(value = "/addAUser_follow",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAUser_follow(User_follow u){
		System.out.println("user_follow = " + u);
		return user_followService.addAUser_follow(u);
	}
	
	//����id�Ƿ����
	@RequestMapping(value = "/checkId",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkId(User u){
		System.out.println("user = " + u);
		String result = userService.checkId(u);
		return result;
	}
}
