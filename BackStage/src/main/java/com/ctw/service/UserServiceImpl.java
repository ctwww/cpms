package com.ctw.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.User;
import com.ctw.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UserMapper userMapper;

	
	
	@Override
	public String adminlogin(String id, String password) {
		User user = userMapper.selectUserById(id);
		if(user == null){
			return "��½ʧ�ܣ��û�������";
		}else{
			if(!user.getPassword().equals(password)){
				return "��½ʧ�ܣ��������";
			}else{
				if(user.getIsAdmin() == false){
					return "user_success";
				}else{
					return "admin_success";
				}
			}
		}
	}
	@Override
	public List<User> getAllUser() {

		List<User> list = userMapper.selectAllUser();
		
		return list;
	}

	@Override
	public String addAUser(User u) {
		User user = userMapper.selectUserById(u.getId());
		if(user != null){
			return "����id�����ظ���";
		}else{
			userMapper.insertUser(u);
			User user2 = userMapper.selectUserById(u.getId());
			if(user2 == null){
				return "����ϵͳ���ʧ�ܣ�";
			}
			return "success";
		}
	}
	@Override
	public String getUsernameById(String id) {
		User user = userMapper.selectUserById(id);
		if(user != null && user.getUsername() != null){
			return user.getUsername();
		}else{
			return null;
		}
	}
	@Override
	public String Userlist2Json(List<User> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(User u : list){
            JSONObject jo = new JSONObject();
            jo.put("id", u.getId());
            jo.put("password", u.getPassword());
            jo.put("wechat_id", u.getWechat_id());
            jo.put("isAdmin", u.getIsAdmin());
            jo.put("username", u.getUsername());
            json.put(jo);
        }
        
        return json.toString();
	}
	@Override
	public String updateUser(User u) {
		User user = userMapper.selectUserById(u.getId());
		if(user == null){
			return "�û�������";
		}
		userMapper.updateUser(u);
		System.out.println("2222");
		return "success";
	}
	@Override
	public String deleteUserById(String id) {
		User user = userMapper.selectUserById(id);
		if(user == null){
			return "ɾ��ʧ�ܣ��û�������";
		}
		userMapper.deleteUserById(id);
		return "success";
	}
	@Override
	public String checkId(User u) {
		User user = userMapper.selectUserById(u.getId());
		if(user == null){
			return "���û�������";
		}
		return "���û�����";
	}
	@Override
	public List<User> getAUserById(User u) {
		User user = userMapper.selectUserById(u.getId());
		if(user == null){
			return null;
		}
		List<User> list = new ArrayList<User>();
		list.add(user);
		return list;
	}
	@Override
	public String updateUserWechat_id(User u) {
		User user = userMapper.selectUserById(u.getId());
		if(user == null){
			return "�û�������";
		}
		userMapper.updateUserWechat_idById(u);
		User user2 = userMapper.selectUserById(u.getId());
		if(user2.getWechat_id().equals(u.getWechat_id())){
			return "success";
		}else{
		return "����ʧ�ܣ�����������ʧ�ܣ�";
		}
	}

}
