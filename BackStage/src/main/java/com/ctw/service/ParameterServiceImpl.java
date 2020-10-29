package com.ctw.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctw.bean.Parameter;
import com.ctw.mapper.ParameterMapper;

@Service
public class ParameterServiceImpl implements ParameterService {
	
	@Autowired(required = true)
	private ParameterMapper parameterMapper;

	@Override
	public String addAParameter(Parameter parameter) {
		Parameter parameter0 = parameterMapper.selectAParameterByLinkAndParameter(parameter);
		if(parameter0 == null){
			parameterMapper.addAParameter(parameter);
		}
		return "success";
	}

	@Override
	public String deleteAParameter(Parameter parameter) {
		parameterMapper.deleteAParameter(parameter);
		return "success";
	}

	@Override
	public String deleteAllParameter(Parameter parameter) {
		List<Parameter> parameter0 = parameterMapper.selectAllParameterByLink(parameter);
		if(parameter0 != null){
			parameterMapper.deleteParameterByLink(parameter);
			return "success";
		}else{
			return "success";
		}
		
	}

	@Override
	public List<Parameter> getParameterListByLink(Parameter p) {
		List<Parameter> parameter = parameterMapper.selectAllParameterByLink(p);
		if(parameter == null){
			return null;
		}
		return parameter;
	}

	@Override
	public String Parameterlist2Json(List<Parameter> list) {
		if(list.size()==0){
			return null;
		}
		JSONArray json = new JSONArray();
        for(Parameter u : list){
            JSONObject jo = new JSONObject();
            jo.put("link", u.getLink());
            jo.put("parameter", u.getParameter());
            jo.put("remarks", u.getRemarks());
            json.put(jo);
        }
        return json.toString();
	}
	
	
}
