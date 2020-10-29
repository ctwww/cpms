package com.ctw.mapper;

import java.util.Date;
import java.util.List;

import com.ctw.bean.Journal;

public interface JournalMapper {

	void addAJournal(Journal u);

	List<Journal> selectAllJournal();

	List<Journal> selectAllUserJournal();

	List<Journal> selectAllOperationJournal();

	List<Journal> selectAllFunctionJournal();

	List<Journal> selectAllSecurityJournal();

	void deleteJournalByDate(Date y);

}
