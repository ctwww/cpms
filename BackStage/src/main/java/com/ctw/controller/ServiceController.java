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
	
	//��ȡȫ����������
	@RequestMapping(value = "/getServiceLinkList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getServiceLinkList(Model model){
		System.out.println("getServiceLinkList");
		List<String> list = my_serviceService.getAllServiceLink();
		System.out.println(my_serviceService.ServiceLinklist2Json(list));
		return my_serviceService.ServiceLinklist2Json(list);
	}
	
	//��ȡȫ��������Ϣ
	@RequestMapping(value = "/showServiceList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showServiceList(Model model) throws JSONException, Exception{
		System.out.println("showServiceList");
		List<My_service> list = my_serviceService.getAllService();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return my_serviceService.Servicelist2Json(list);
	}

	//��ȡȫ�������������Ϣ
	@RequestMapping(value = "/showUncheckedServiceList",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String showUncheckedServiceList(Model model) throws JSONException, Exception{
		System.out.println("showUncheckedServiceList");
		List<My_service> list = my_serviceService.getAllUncheckedService();
		//System.out.println(my_serviceService.Servicelist2Json(list));
		return my_serviceService.Servicelist2Json(list);
	}

	
	//��ȡǰ̨socket��Ϣ
	@RequestMapping(value = "/getFront_socket",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getFront_socket(Model model){
		System.out.println("getFront_socket");
		Front_socket front_socket = front_socketService.getFront_socket();
		System.out.println(front_socket);
		System.out.println(front_socketService.Front_socket2Json(front_socket));
		return front_socketService.Front_socket2Json(front_socket);
	}
	
	//�޸�ǰ̨socket
	@RequestMapping(value = "/modify_front_socket",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateUser(Front_socket u, Model model){
		System.out.println("Front_socket = " + u);
		String result = front_socketService.updateFront_socket(u);
		System.out.println(result);
		return result;
	}
	
	//��˷�������
	@RequestMapping(value = "/checkType",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkType(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkType(service);
		System.out.println(result);
		return result;
	}	
	
	//��˷���
	@RequestMapping(value = "/checkLink",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkLink(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkLink(service.getLink());
		System.out.println(result);
		return result;
	}
	
	//��˷����޸�
	@RequestMapping(value = "/checkLinkAndModify",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String checkLinkAndModify(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.checkLink(service.getLink());
		System.out.println(result);
		if(result.startsWith("���ӿɷ��ʣ�")){
			service.setIsPass(true);
		}else{
			service.setIsPass(false);
		}
		my_serviceService.setisPass(service);
		return "�����ɣ�" + result;
	}
	
	//ɾ��һ������
	@RequestMapping(value = "/deleteAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAService(My_service service){
		System.out.println("Service = " + service);
		String result = my_serviceService.deleteAService(service);
		System.out.println(result);
		return result;
	}
	
	//�޸�һ������
	@RequestMapping(value = "/updateAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String updateAService(My_service service){
		System.out.println("Service = " + service);
		String result0 = my_serviceService.checkLink(service.getLink());
		System.out.println(result0);
		if(result0.startsWith("���ӿɷ��ʣ�")){
			service.setIsPass(true);
		}else{
			service.setIsPass(false);
		}
		service.setIsChecked(true);
		String result = my_serviceService.updateAService(service);
		System.out.println(result);
		return "success";
	}
		
	//����һ������
	@RequestMapping(value = "/addAService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAService(My_service service){
	    System.out.println("Service = " + service);
	    String check_result = my_serviceService.checkLink(service.getLink());
	    if(service.getIsChecked() == null){
	    	service.setIsChecked(true);
	    }
	    if(check_result.startsWith("���ӿɷ��ʣ�")){
	    	service.setIsPass(true);
	    }else{
	    	service.setIsPass(false);
	    }
		String result = my_serviceService.addAService(service);
		System.out.println(result);
		return result;
	}
	
	//��ȡһ�������Ƿ����
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
	
	//ͬ���������
	@RequestMapping(value = "/addUncheckedService",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addUncheckedService(My_service service){
		String result = my_serviceService.addUncheckedService(service);
		System.out.println(result);
		return result;
	}
	
	//���һ������
	@RequestMapping(value = "/addAParameter",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String addAParameter(Parameter parameter){
		String result = parameter_service.addAParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//ɾ��һ������
	@RequestMapping(value = "/deleteAParameter",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAParameter(Parameter parameter){
		String result = parameter_service.deleteAParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//ɾ��һ����������в���
	@RequestMapping(value = "/deleteParameterByLink",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String deleteAllParameter(Parameter parameter){
		String result = parameter_service.deleteAllParameter(parameter);
		System.out.println(result);
		return result;
	}
	
	//��ȡһ����������в���
	@RequestMapping(value = "/getParameterListByLink",produces={"application/json;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getParameterListByLink(Parameter p){
		System.out.println("getParameterListByLink");
		List<Parameter> list = parameter_service.getParameterListByLink(p);
		System.out.println(parameter_service.Parameterlist2Json(list));
		return parameter_service.Parameterlist2Json(list);
	}
	
	//ϵͳÿ��21����ִ�У�������isPass
	@org.springframework.scheduling.annotation.Scheduled(cron = "0 0 21 * * ?")//0/5 * * * * ?   
	public void Scheduled() throws Exception{
		List<My_service> list = my_serviceService.getAllService();
		String illustrate = "";
		for(My_service u : list){
			System.out.println("green");
			String result = my_serviceService.checkLink(u.getLink());
			if(result.startsWith("���ӿɷ��ʣ�")){
				if(u.getIsPass()==false){
					u.setIsPass(true);
					illustrate = illustrate + "����Ϊ"+u.getLink()+"�ķ�����δͨ����Ϊͨ��;";
				}
			}else{
				if(u.getIsPass()==true){
					u.setIsPass(false);
					illustrate = illustrate + "����Ϊ"+u.getLink()+"�ķ�����ͨ����Ϊδͨ��;";
				}
			}
			my_serviceService.setisPass(u);
		}
		Journal j = new Journal();
		j.setId("00000");
		j.setOperation("���");
		j.setType("ϵͳ��־");
		long l = System.currentTimeMillis();
		Date time=new Date(l);
		j.setDate(time);
		illustrate = illustrate.substring(0,illustrate.length() - 1);
		if(illustrate.equals("")){
			j.setIllustrate("���ȫ�������޸Ķ�");
		}else{
			j.setIllustrate("���ȫ�����񣬾���Ķ�Ϊ��" + illustrate);
		}
		journal_service.addAJournal(j);
    }
}
