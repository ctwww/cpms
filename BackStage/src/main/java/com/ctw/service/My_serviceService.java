package com.ctw.service;

import java.util.List;

import org.json.JSONException;

import com.ctw.bean.My_service;

public interface My_serviceService {

	public List<String> getAllServiceLink();

	public String ServiceLinklist2Json(List<String> list);

	public List<My_service> getAllService();

	public String Servicelist2Json(List<My_service> list) throws JSONException, Exception;

	public String checkLink(String link);

	public String deleteAService(My_service service);

	public String addAService(My_service service);

	public void setisPass(My_service service);

	public My_service getAService(My_service service);

	public String checkType(My_service service);

	public List<My_service> getAllUncheckedService();

	public String addUncheckedService(My_service service);

	public String updateAService(My_service service);

}
