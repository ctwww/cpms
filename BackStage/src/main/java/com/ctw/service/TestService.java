package com.ctw.service;

import java.util.List;

import com.ctw.bean.Test;

public interface TestService {
	
	public List<Test> getAlltips();

	public String Tipslist2Json(List<Test> list);
	
}
