package com.ctw.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctw.bean.Access_statistics;
import com.ctw.bean.Journal;
import com.ctw.service.Access_statisticsService;
import com.ctw.service.JournalService;

@Controller
public class Access_statisticsController {
	
	@Autowired(required = true)
	private Access_statisticsService access_statisticsservice;
	@Autowired(required = true)
	private JournalService journal_service;
	
	//ϵͳÿ��23����ִ�У�ɾ������ǰ��ͳ�ƣ�����µĿ�ֵ
	@org.springframework.scheduling.annotation.Scheduled(cron = "0 0 23 * * ?")//0/5 * * * * ?     
	public void Scheduled() throws Exception{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.YEAR, -5);
        Date y = c.getTime();
        access_statisticsservice.deleteAccessByDate(y);
        c.add(Calendar.YEAR, 5);
        c.add(Calendar.DAY_OF_YEAR, 1);
        
        //ÿ�춨ʱ���sumΪ0�ĸ�����ķ��ʣ����ڲ���Ҫ��
        /*Date date = c.getTime();
        List<String> link = my_serviceservice.getAllServiceLink();
        Access_statistics access = new Access_statistics();
        access.setDate(date);
        access.setSum(0);
        for(int i = 0;i< link.size();i++){
        	access.setLink(link.get(i));
        	access_statisticsservice.addAccess(access);
        }*/
        Journal j = new Journal();//�����־
		j.setId("00000");
		j.setOperation("ɾ��");
		j.setType("ϵͳ��־");
		j.setIllustrate("ɾ��������ǰ�ķ������ͳ������");
		long l = System.currentTimeMillis();
		Date time=new Date(l);
		j.setDate(time);
		journal_service.addAJournal(j);
	}
	
	//��ȡȫ��ͳ����Ϣ
	@RequestMapping(value = "/showAccessList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showAccessList(Model model) throws JSONException, Exception{
		System.out.println("showAccessList");
		List<Access_statistics> list = access_statisticsservice.getAllAccess();
		System.out.println("size:"+list.size());
		return access_statisticsservice.Accesslist2Json(list);
	}
}
