package com.ctw.service;

import java.util.Date;
import java.util.List;

import com.ctw.bean.Access_statistics;

public interface Access_statisticsService {

	void deleteAccessByDate(Date y);

	void addAccess(Access_statistics access);

	List<Access_statistics> getAllAccess();

	String Accesslist2Json(List<Access_statistics> list);

	String submitAccess(Access_statistics u);

}
