package com.ctw.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.Journal;
import com.ctw.mapper.JournalMapper;

@Service
public class JournalServiceImpl implements JournalService {

	@Autowired(required = true)
	private JournalMapper journalMapper;
	
	@Override
	public String addAJournal(Journal u) {
		// TODO Auto-generated method stub
		journalMapper.addAJournal(u);
		return "success";
	}

	@Override
	public List<Journal> getAllJournal() {
		
		return journalMapper.selectAllJournal();
	}

	@Override
	public String Journallist2Json(List<Journal> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(Journal u : list){
            JSONObject jo = new JSONObject();
            jo.put("id", u.getId());
            jo.put("date", u.getDate());
            jo.put("illustrate", u.getIllustrate());
            jo.put("type", u.getType());
            jo.put("operation",u.getOperation());
            json.put(jo);
        }
        return json.toString();
	}

	@Override
	public List<Journal> getAllUserJournal() {
		// TODO Auto-generated method stub
		return journalMapper.selectAllUserJournal();
	}

	@Override
	public List<Journal> getAllOperationJournal() {
		// TODO Auto-generated method stub
		return journalMapper.selectAllOperationJournal();
	}

	@Override
	public List<Journal> getAllFunctionJournal() {
		// TODO Auto-generated method stub
		return journalMapper.selectAllFunctionJournal();
	}

	@Override
	public List<Journal> getAllSecurityJournal() {
		// TODO Auto-generated method stub
		return journalMapper.selectAllSecurityJournal();
	}


	@Override
	public void deleteJournalByDate(Date y) {
		// TODO Auto-generated method stub
		Journal j = new Journal();
		j.setDate(y);
		journalMapper.deleteJournalByDate(y);
	}

}
