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
			return "���ӿɷ��ʣ�"+status;
		}else{
			return "���Ӳ��ɷ��ʣ�"+status;
		}
	}
	
	public int getUrlStatus(String path) {
		int stateNum = 0;
		//System.setProperty("http.proxyHost", "http://localhost:8080/BackStage/");  
	//	System.setProperty("http.proxyPort","80");     
		// start
        try {
            HttpURLConnection httpUrlConn = (HttpURLConnection) new URL(path).openConnection();
            // ��������������ʱ����λ�����룩
            httpUrlConn.setConnectTimeout(200);
            // ���ô�������ȡ���ݳ�ʱ����λ�����룩
            httpUrlConn.setReadTimeout(200);
            int statusCode = httpUrlConn.getResponseCode();
            stateNum = statusCode;
            if (statusCode != 200) {
                System.out.println("������");
            } else {
                System.out.println("���Է���");
            }
            // �����ر�
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
			return "ɾ��ʧ�ܣ��÷��񱾾Ͳ����ڣ�";
		}
		my_serviceMapper.deleteAService(service);
		My_service service2 = my_serviceMapper.selectServiceByLink(service);
		if(service2 == null){
			return "success";
		}
		return "ɾ��ʧ�ܣ�����������";
	}

	@Override
	public String addAService(My_service service) {
		My_service service1 = my_serviceMapper.selectServiceByLink(service);
		if(service1 != null){
			return "����ʧ�ܣ�������ͬ���ӣ�";
		}
		my_serviceMapper.insertAService(service);
		My_service service2 = my_serviceMapper.selectServiceByLink(service);
		if(service2 != null){
			return "success";
		}
		return "����ʧ�ܣ�����������";
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
			return "����ķ�������Ϊ������";
		}else{
			return "����ķ������ʹ��ڣ���ĿΪ��"+count;
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
		return "���ʧ�ܣ�����������";
	}

	@Override
	public String updateAService(My_service service) {
		my_serviceMapper.updateAService(service);
		return "success";
	}


}
