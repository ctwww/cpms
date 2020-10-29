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
	
	//系统每天23点自执行，删除五年前的统计，添加新的空值
	@org.springframework.scheduling.annotation.Scheduled(cron = "0 0 23 * * ?")//0/5 * * * * ?     
	public void Scheduled() throws Exception{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.YEAR, -5);
        Date y = c.getTime();
        access_statisticsservice.deleteAccessByDate(y);
        c.add(Calendar.YEAR, 5);
        c.add(Calendar.DAY_OF_YEAR, 1);
        
        //每天定时添加sum为0的各服务的访问，现在不需要了
        /*Date date = c.getTime();
        List<String> link = my_serviceservice.getAllServiceLink();
        Access_statistics access = new Access_statistics();
        access.setDate(date);
        access.setSum(0);
        for(int i = 0;i< link.size();i++){
        	access.setLink(link.get(i));
        	access_statisticsservice.addAccess(access);
        }*/
        Journal j = new Journal();//添加日志
		j.setId("00000");
		j.setOperation("删除");
		j.setType("系统日志");
		j.setIllustrate("删除了五年前的服务访问统计数据");
		long l = System.currentTimeMillis();
		Date time=new Date(l);
		j.setDate(time);
		journal_service.addAJournal(j);
	}
	
	//获取全部统计信息
	@RequestMapping(value = "/showAccessList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showAccessList(Model model) throws JSONException, Exception{
		System.out.println("showAccessList");
		List<Access_statistics> list = access_statisticsservice.getAllAccess();
		System.out.println("size:"+list.size());
		return access_statisticsservice.Accesslist2Json(list);
	}
}
