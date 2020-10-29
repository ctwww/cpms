package com.ctw.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.User_follow;
import com.ctw.mapper.User_followMapper;

@Service
public class User_followServiceImpl implements User_followService {
	
	@Autowired(required = true)
	private User_followMapper user_followMapper;
	
	@Override
	public List<User_follow> getAUser_followList(String id) {
		List<User_follow> list = user_followMapper.selectAUser_followList(id);
		
		return list;
	}
	
	@Override
	public String User_followlist2Json(List<User_follow> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(User_follow u : list){
            JSONObject jo = new JSONObject();
            jo.put("id", u.getId());
            jo.put("link", u.getLink());
            jo.put("follow_remarks", u.getFollow_remarks());
            json.put(jo);
        }
        
        return json.toString();
	}

	@Override
	public String deleteAFollow(User_follow u) {
		System.out.println("start1");
		
		User_follow follow = user_followMapper.selectAUser_follow(u);
		System.out.println(follow);
		if(follow != null){
			user_followMapper.deleteAUser_follow(u);
			User_follow follow2 = user_followMapper.selectAUser_follow(u);
			if(follow2 == null){
				return "success";
			}else{
				return "删除失败！";
			}
		}else{
			return "该数据已经删除！";
		}
	}

	@Override
	public String addAUser_follow(User_follow u) {
		User_follow user_follow = user_followMapper.selectAUser_follow(u);
		if(user_follow != null){
			return "错误，不能重复！";
		}else{
			user_followMapper.insertAUser_follow(u);
			User_follow user_follow2 = user_followMapper.selectAUser_follow(u);
			if(user_follow2 == null){
				return "错误，系统添加失败！";
			}
			return "success";
		}
	}

	@Override
	public List<User_follow> getAUser_followListByLink(String link) {
		List<User_follow> list = user_followMapper.selectAUser_followListByLink(link);
		return list;
	}
}
