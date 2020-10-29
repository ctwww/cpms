package com.ctw.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.Front_socket;
import com.ctw.mapper.Front_socketMapper;

@Service
public class Front_socketServiceImpl implements Front_socketService{

	@Autowired(required = true)
	private Front_socketMapper front_socketMapper;
	@Override
	public Front_socket getFront_socket() {
		System.out.println("ok!");
		return front_socketMapper.selectFront_socket();
	}

	@Override
	public String Front_socket2Json(Front_socket front_socket) {
		JSONArray json = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("client_ip", front_socket.getClient_ip());
        jo.put("client_port", front_socket.getClient_port());
        json.put(jo);
        return json.toString();
	}

	@Override
	public String updateFront_socket(Front_socket u) {
		Front_socket u2 = front_socketMapper.selectFront_socket();
		if(u2.getClient_ip().equals(u.getClient_ip()) && u2.getClient_port().equals(u.getClient_port())){
			return "失败！您并未进行修改";
		}else{
			front_socketMapper.updateFront_socket(u);
			Front_socket u3 = front_socketMapper.selectFront_socket();
			if(u3.getClient_ip().equals(u.getClient_ip()) && u3.getClient_port().equals(u.getClient_port())){
				return "success";
			}else{
				return "失败！服务器未工作";
			}
		}
	}

}
