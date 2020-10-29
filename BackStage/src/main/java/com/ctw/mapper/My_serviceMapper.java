package com.ctw.mapper;

import java.util.List;

import com.ctw.bean.My_service;

public interface My_serviceMapper {

	List<String> selectAllServiceLink();

	List<My_service> selectAllService();

	void deleteAService(My_service service);

	My_service selectServiceByLink(My_service service);

	void insertAService(My_service service);

	void updateisPass(My_service service);

	int selectTypeCount(My_service service);

	List<My_service> selectAllUnckeckedService();

	void setIscheckedTrueByLink(My_service service);

	void updateAService(My_service service);

}
