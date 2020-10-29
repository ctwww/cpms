package com.ctw.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctw.bean.Front_socket;
import com.ctw.bean.Journal;
import com.ctw.bean.My_service;
import com.ctw.bean.Parameter;
import com.ctw.service.Front_socketService;
import com.ctw.service.JournalService;
import com.ctw.service.My_serviceService;
import com.ctw.service.ParameterService;

@Controller
public class ServiceController {
	
	@Autowired(required = true)
	private My_serviceService my_serviceService;
	@Autowired(required = true)
	private Front_socketService front_socketService;
	@Autowired(required = true)
	private JournalService journal_service;
	@Autowired(required = true)
	private ParameterService parameter_service;
	
	//获取全部服务链接
	@RequestMapping(value = "/getServiceLinkList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getServiceLinkList(Model model){
		System.out.println("getServiceLinkList");
		List<String> list = my_serviceService.getAllServiceLink();
		System.out.println(my_serviceService.ServiceLinklist2Json(list));
		return my_serviceService.ServiceLinklist2Json(list);
	}
	
	//获取全部服务信息
	@RequestMapping(value = "/showServiceList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showServiceList(Model model) throws JSONException, Exception{
		System.out.println("showServiceList");
		List<My_service> list = my_serviceService.getAllService();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return my_serviceService.Servicelist2Json(list);
	}

	//获取全部待处理服务信息
	@RequestMapping(value = "/showUncheckedServiceList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showUncheckedServiceList(Model model) throws JSONException, Exception{
		System.out.println("showUncheckedServiceList");
		List<My_service> list = my_serviceService.getAllUncheckedService();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return my_serviceService.Servicelist2Json(list);
	}

	
	//获取前台socket信息
	@RequestMapping(value = "/getFront_socket",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getFront_socket(Model model){
		System.out.println("getFront_socket");
		Front_socket front_socket = front_socketService.getFront_socket();
		System.out.println(front_socket);
		System.out.println(front_socketService.Front_socket2Json(front_socket));
		return front_socketService.Front_socket2Json(front_socket);
	}
	
	//修改前台socket
	@RequestMapping(value = "/modify_front_socket",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateUser(Front_socket u, Model model){
		System.out.println("Front_socket = " + u);
		String result = front_socketService.updateFront_socket(u);
		System.out.println(result);
		return result;
	}
	
	//审核服务类型
	@RequestMapping(value = "/checkType",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkType(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkType(service);
		System.out.println(result);
		return result;
	}	
	
	//审核服务
	@RequestMapping(value = "/checkLink",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkLink(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkLink(service.getLink());
		System.out.println(result);
		return result;
	}
	
	//审核服务并修改
	@RequestMapping(value = "/checkLinkAndModify",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkLinkAndModify(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkLink(service.getLink());
		System.out.println(result);
		if(result.startsWith("链接可访问：")){
			service.setIsPass(true);
		}else{
			service.setIsPass(false);
		}
		my_serviceService.setisPass(service);
		return "审核完成：" + result;
	}
	
	//删除一个服务
	@RequestMapping(value = "/deleteAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAService(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.deleteAService(service);
		System.out.println(result);
		return result;
	}
	
	//修改一个服务
	@RequestMapping(value = "/updateAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateAService(My_service service){
		System.out.println("Service = " + service);
		String result0 = my_serviceService.checkLink(service.getLink());
		System.out.println(result0);
		if(result0.startsWith("链接可访问：")){
			service.setIsPass(true);
		}else{
			service.setIsPass(false);
		}
		service.setIsChecked(true);
		String result = my_serviceService.updateAService(service);
		System.out.println(result);
		return "success";
	}
		
	//新增一个服务
	@RequestMapping(value = "/addAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAService(My_service service){
	    System.out.println("Service = " + service);
	    String check_result = my_serviceService.checkLink(service.getLink());
	    if(service.getIsChecked() == null){
	    	service.setIsChecked(true);
	    }
	    if(check_result.startsWith("链接可访问：")){
	    	service.setIsPass(true);
	    }else{
	    	service.setIsPass(false);
	    }
		String result = my_serviceService.addAService(service);
		System.out.println(result);
		return result;
	}
	
	//获取一个服务是否存在
	@RequestMapping(value = "/checkLinkExist",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkLinkExist(My_service service) throws JSONException, Exception{
		System.out.println("showServiceList");
		My_service service_has = my_serviceService.getAService(service);
		if(service_has == null){
			return "not exist";
		}else{
			return "exist";
		}
	}
	
	//同意服务申请
	@RequestMapping(value = "/addUncheckedService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addUncheckedService(My_service service){
		String result = my_serviceService.addUncheckedService(service);
		System.out.println(result);
		return result;
	}
	
	//添加一个参数
	@RequestMapping(value = "/addAParameter",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAParameter(Parameter parameter){
		String result = parameter_service.addAParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//删除一个参数
	@RequestMapping(value = "/deleteAParameter",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAParameter(Parameter parameter){
		String result = parameter_service.deleteAParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//删除一个服务的所有参数
	@RequestMapping(value = "/deleteParameterByLink",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAllParameter(Parameter parameter){
		String result = parameter_service.deleteAllParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//获取一个服务的所有参数
	@RequestMapping(value = "/getParameterListByLink",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getParameterListByLink(Parameter p){
		System.out.println("getParameterListByLink");
		List<Parameter> list = parameter_service.getParameterListByLink(p);
		System.out.println(parameter_service.Parameterlist2Json(list));
		return parameter_service.Parameterlist2Json(list);
	}
	
	//系统每天21点自执行，检查服务isPass
	@org.springframework.scheduling.annotation.Scheduled(cron = "0 0 21 * * ?")//0/5 * * * * ?   
	public void Scheduled() throws Exception{
		List<My_service> list = my_serviceService.getAllService();
		String illustrate = "";
		for(My_service u : list){
			System.out.println("green");
			String result = my_serviceService.checkLink(u.getLink());
			if(result.startsWith("链接可访问：")){
				if(u.getIsPass()==false){
					u.setIsPass(true);
					illustrate = illustrate + "链接为"+u.getLink()+"的服务由未通过改为通过;";
				}
			}else{
				if(u.getIsPass()==true){
					u.setIsPass(false);
					illustrate = illustrate + "链接为"+u.getLink()+"的服务由通过改为未通过;";
				}
			}
			my_serviceService.setisPass(u);
		}
		Journal j = new Journal();
		j.setId("00000");
		j.setOperation("审核");
		j.setType("系统日志");
		long l = System.currentTimeMillis();
		Date time=new Date(l);
		j.setDate(time);
		illustrate = illustrate.substring(0,illustrate.length() - 1);
		if(illustrate.equals("")){
			j.setIllustrate("审核全部服务，无改动");
		}else{
			j.setIllustrate("审核全部服务，具体改动为：" + illustrate);
		}
		journal_service.addAJournal(j);
    }
}
