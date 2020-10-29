package com.ctw.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.Access_statistics;
import com.ctw.mapper.Access_statisticsMapper;

@Service
public class Access_statisticsServiceImpl implements Access_statisticsService {

	@Autowired(required = true)
	private Access_statisticsMapper access_statisticsmapper;
	@Override
	public void deleteAccessByDate(Date y) {
		// TODO Auto-generated method stub
		access_statisticsmapper.deleteAccessByDate(y);
	}
	@Override
	public void addAccess(Access_statistics access) {
		// TODO Auto-generated method stub
		access_statisticsmapper.insertStatictics(access);
	}
	@Override
	public List<Access_statistics> getAllAccess() {
		// TODO Auto-generated method stub
		return access_statisticsmapper.getAllAccess();
	}
	@Override
	public String Accesslist2Json(List<Access_statistics> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Access_statistics u : list){
            JSONObject jo = new JSONObject();
            jo.put("date", sdf.format(u.getDate()));
            jo.put("link", u.getLink());
            jo.put("sum", u.getSum());
            json.put(jo);
        }
        return json.toString();
	}
	@Override
	public String submitAccess(Access_statistics u) {
		Access_statistics u1 = access_statisticsmapper.selectAAccess(u);
		if(u1 == null){
			access_statisticsmapper.insertStatictics(u);
		}else{
			u.setSum(u.getSum()+u1.getSum());
			access_statisticsmapper.updateAAccess(u);
		}
		return "success";
	}

}
