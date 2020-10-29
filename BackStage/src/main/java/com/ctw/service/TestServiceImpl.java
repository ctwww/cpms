package com.ctw.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.Test;
import com.ctw.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired(required = true)
	private TestMapper testMapper;
	
	@Override
	public List<Test> getAlltips() {
		return testMapper.selectAllTips();
	}

	@Override
	public String Tipslist2Json(List<Test> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Test u : list){
            JSONObject jo = new JSONObject();
            jo.put("date", sdf.format(u.getDate()));
            jo.put("id", u.getId());
            jo.put("content", u.getContent());
            jo.put("title", u.getTitle());
            json.put(jo);
        }
        return json.toString();
	}

}
