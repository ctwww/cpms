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
	
	
	//获取用户信息：SystemController的getAUser方法:用户信息无法查询！;json
	
	//绑定微信号
	@RequestMapping(value = "/updateUserWechat_id",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateUserWechat_id(User u){
		System.out.println("user = " + u);
		String result = userService.updateUserWechat_id(u);
		System.out.println(result);
		return result;//success,用户不存在,更新失败：服务器处理失败！
	}
	
	
	//获取服务列表:ServiceController的showServiceList：json
	
	
	//获取某id服务关注列表:SystemController的getAUserFollow:json
	
	
	//修改关注:SystemController的deleteAFollow:success,删除失败！,该数据已经删除！;
	           //SystemController的addAUser_follow:错误，不能重复！,错误，系统添加失败！,success
	
	
	//新增日志:JournalController的addJournal:success
	//用户访问某服务
	//用户的微信号绑定相关操作日志
	//用户的服务相关操作日志
	
	
	//新增统计数据
	@RequestMapping(value = "/submitAccess",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String submitAccess(Access_statistics u){
		System.out.println("Access_statistics = " + u);
		String result = access_statisticsservice.submitAccess(u);
		System.out.println(result);
		return result;//success,用户不存在,更新失败：服务器处理失败！
	}
	
	//获取全部服务链接
	@RequestMapping(value = "/getTipsList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getTipsList(Model model){
		System.out.println("getServiceLinkList");
		List<Test> list = testService.getAlltips();
		System.out.println(testService.Tipslist2Json(list));
		return testService.Tipslist2Json(list);
	}
}
