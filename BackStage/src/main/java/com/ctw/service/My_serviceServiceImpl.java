package com.ctw.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.My_service;
import com.ctw.mapper.My_serviceMapper;

@Service
public class My_serviceServiceImpl implements My_serviceService {

	@Autowired(required = true)
	private My_serviceMapper my_serviceMapper;
	
	@Override
	public List<String> getAllServiceLink() {
		List<String> list = my_serviceMapper.selectAllServiceLink();
		return list;
	}

	@Override
	public String ServiceLinklist2Json(List<String> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(String u : list){
            JSONObject jo = new JSONObject();
            jo.put("link", u);
            json.put(jo);
        }
        return json.toString();
	}

	@Override
	public List<My_service> getAllService() {
		List<My_service> list = my_serviceMapper.selectAllService();
		return list;
	}

	@Override
	public String Servicelist2Json(List<My_service> list) throws JSONException, Exception {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(My_service u : list){
            JSONObject jo = new JSONObject();
            jo.put("link", u.getLink());
            jo.put("link_name", u.getLink_name());
            jo.put("provider_name", u.getProvider_name());
            jo.put("isPass", u.getIsPass());
            jo.put("remarks", u.getRemarks());
            jo.put("type", u.getType());
            jo.put("img", u.getImg());
            jo.put("isChecked", u.getIsChecked());
            jo.put("has_parameter", u.getHas_parameter());
            json.put(jo);
        }
        
        return json.toString();
	}

	@Override
	public String checkLink(String link) {
		int status = getUrlStatus(link);
		if(status < 400){
			return "链接可访问："+status;
		}else{
			return "链接不可访问："+status;
		}
	}
	
	public int getUrlStatus(String path) {
		int stateNum = 0;
		//System.setProperty("http.proxyHost", "http://localhost:8080/BackStage/");  
	//	System.setProperty("http.proxyPort","80");     
		// start
        try {
            HttpURLConnection httpUrlConn = (HttpURLConnection) new URL(path).openConnection();
            // 设置连接主机超时（单位：毫秒）
            httpUrlConn.setConnectTimeout(200);
            // 设置从主机读取数据超时（单位：毫秒）
            httpUrlConn.setReadTimeout(200);
            int statusCode = httpUrlConn.getResponseCode();
            stateNum = statusCode;
            if (statusCode != 200) {
                System.out.println("不存在");
            } else {
                System.out.println("可以访问");
            }
            // 打开流关闭
            InputStream is2 = httpUrlConn.getInputStream();
            is2.close();
            return statusCode;
        } catch (Exception e) {
        	stateNum = 404;
        }
        // end
		return stateNum;
	}

	@Override
	public String deleteAService(My_service service) {
		My_service service1 = my_serviceMapper.selectServiceByLink(service);
		if(service1 == null){
			return "删除失败：该服务本就不存在！";
		}
		my_serviceMapper.deleteAService(service);
		My_service service2 = my_serviceMapper.selectServiceByLink(service);
		if(service2 == null){
			return "success";
		}
		return "删除失败：服务器错误！";
	}

	@Override
	public String addAService(My_service service) {
		My_service service1 = my_serviceMapper.selectServiceByLink(service);
		if(service1 != null){
			return "新增失败：存在相同链接！";
		}
		my_serviceMapper.insertAService(service);
		My_service service2 = my_serviceMapper.selectServiceByLink(service);
		if(service2 != null){
			return "success";
		}
		return "新增失败：服务器错误！";
	}

	@Override
	public void setisPass(My_service service) {
		// TODO Auto-generated method stub
		my_serviceMapper.updateisPass(service);
	}

	@Override
	public My_service getAService(My_service service) {
		return my_serviceMapper.selectServiceByLink(service);
	}

	@Override
	public String checkType(My_service service) {
		int count = my_serviceMapper.selectTypeCount(service);
		if(count == 0){
			return "输入的服务类型为新类型";
		}else{
			return "输入的服务类型存在，数目为："+count;
		}
		
	}

	@Override
	public List<My_service> getAllUncheckedService() {
		List<My_service> list = my_serviceMapper.selectAllUnckeckedService();
		return list;
	}

	@Override
	public String addUncheckedService(My_service service) {
		my_serviceMapper.setIscheckedTrueByLink(service);
		My_service service2 = my_serviceMapper.selectServiceByLink(service);
		if(service2.getIsChecked()==true){
			return "success";
		}
		return "添加失败：服务器出错";
	}

	@Override
	public String updateAService(My_service service) {
		my_serviceMapper.updateAService(service);
		return "success";
	}


}
