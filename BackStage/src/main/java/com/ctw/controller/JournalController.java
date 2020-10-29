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

import com.ctw.bean.Journal;
import com.ctw.service.JournalService;

@Controller
public class JournalController {

	@Autowired(required = true)
	private JournalService journal_service;
	
   //获取全部日志信息
	@RequestMapping(value = "/showJournalList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showJournalList(Model model) throws JSONException, Exception{
		System.out.println("showJournalList");
		List<Journal> list = journal_service.getAllJournal();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return journal_service.Journallist2Json(list);
	}
	
	//获取用户日志信息
	@RequestMapping(value = "/showUserJournalList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showUserJournalList(Model model) throws JSONException, Exception{
		System.out.println("showUserJournalList");
		List<Journal> list = journal_service.getAllUserJournal();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return journal_service.Journallist2Json(list);
	}
	
	//获取操作日志信息
	@RequestMapping(value = "/showOperationJournalList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showOperationJournalList(Model model) throws JSONException, Exception{
		System.out.println("showOperationJournalList");
		List<Journal> list = journal_service.getAllOperationJournal();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return journal_service.Journallist2Json(list);
	}
	
	//获取操作日志信息
	@RequestMapping(value = "/showFunctionJournalList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showFunctionJournalList(Model model) throws JSONException, Exception{
		System.out.println("showFunctionJournalList");
		List<Journal> list = journal_service.getAllFunctionJournal();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return journal_service.Journallist2Json(list);
	}
	
	//获取安全日志信息
	@RequestMapping(value = "/showSecurityJournalList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showSecurityJournalList(Model model) throws JSONException, Exception{
		System.out.println("showSecurityJournalList");
		List<Journal> list = journal_service.getAllSecurityJournal();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return journal_service.Journallist2Json(list);
	}
	
	//新增日志
	//用户访问某服务
	//用户的微信号绑定相关操作日志
	//用户的服务相关操作日志
	@RequestMapping(value = "/addJournal",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addJournal(Journal u){
		System.out.println("journal = " + u);
		String result = journal_service.addAJournal(u);
		System.out.println(result);
		return result;//success
	}
	
	//系统每天22点自执行，删除一年前的日志
	@org.springframework.scheduling.annotation.Scheduled(cron = "0 0 22 * * ?")//0/5 * * * * ?
	public void Scheduled() throws Exception{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        journal_service.deleteJournalByDate(y);
        
        Journal j = new Journal();
		j.setId("00000");
		j.setOperation("删除");
		j.setType("系统日志");
		j.setIllustrate("删除了一年前的日志");
		long l = System.currentTimeMillis();
		Date time=new Date(l);
		j.setDate(time);
		journal_service.addAJournal(j);
	}
}
