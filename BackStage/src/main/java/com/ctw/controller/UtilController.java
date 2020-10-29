package com.ctw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctw.bean.Access_statistics;
import com.ctw.bean.Test;
import com.ctw.bean.User;
import com.ctw.service.Access_statisticsService;
import com.ctw.service.TestService;
import com.ctw.service.UserService;

@Controller
public class UtilController {
	
	@Autowired(required = true)
	private UserService userService;
	@Autowired(required = true)
	private Access_statisticsService access_statisticsservice;
	@Autowired(required = true)
	private TestService testService;
	
	
	//��ȡ�û���Ϣ��SystemController��getAUser����:�û���Ϣ�޷���ѯ��;json
	
	//��΢�ź�
	@RequestMapping(value = "/updateUserWechat_id",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateUserWechat_id(User u){
		System.out.println("user = " + u);
		String result = userService.updateUserWechat_id(u);
		System.out.println(result);
		return result;//success,�û�������,����ʧ�ܣ�����������ʧ�ܣ�
	}
	
	
	//��ȡ�����б�:ServiceController��showServiceList��json
	
	
	//��ȡĳid�����ע�б�:SystemController��getAUserFollow:json
	
	
	//�޸Ĺ�ע:SystemController��deleteAFollow:success,ɾ��ʧ�ܣ�,�������Ѿ�ɾ����;
	           //SystemController��addAUser_follow:���󣬲����ظ���,����ϵͳ���ʧ�ܣ�,success
	
	
	//������־:JournalController��addJournal:success
	//�û�����ĳ����
	//�û���΢�źŰ���ز�����־
	//�û��ķ�����ز�����־
	
	
	//����ͳ������
	@RequestMapping(value = "/submitAccess",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String submitAccess(Access_statistics u){
		System.out.println("Access_statistics = " + u);
		String result = access_statisticsservice.submitAccess(u);
		System.out.println(result);
		return result;//success,�û�������,����ʧ�ܣ�����������ʧ�ܣ�
	}
	
	//��ȡȫ����������
	@RequestMapping(value = "/getTipsList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getTipsList(Model model){
		System.out.println("getServiceLinkList");
		List<Test> list = testService.getAlltips();
		System.out.println(testService.Tipslist2Json(list));
		return testService.Tipslist2Json(list);
	}
}
