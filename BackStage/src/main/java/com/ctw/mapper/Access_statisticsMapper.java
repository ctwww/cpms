package com.ctw.mapper;

import java.util.Date;
import java.util.List;

import com.ctw.bean.Access_statistics;

public interface Access_statisticsMapper {

	void deleteAccessByDate(Date y);

	public List<Access_statistics> getAllAccess();
	
	public void insertStatictics(Access_statistics access_statistics);

	Access_statistics selectAAccess(Access_statistics u);

	void updateAAccess(Access_statistics u);
}
