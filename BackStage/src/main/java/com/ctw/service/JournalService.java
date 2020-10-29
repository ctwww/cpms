package com.ctw.service;

import java.util.Date;
import java.util.List;

import com.ctw.bean.Journal;

public interface JournalService {

	String addAJournal(Journal u);

	List<Journal> getAllJournal();

	String Journallist2Json(List<Journal> list);

	List<Journal> getAllUserJournal();

	List<Journal> getAllOperationJournal();

	List<Journal> getAllFunctionJournal();

	List<Journal> getAllSecurityJournal();

	void deleteJournalByDate(Date y);

}
