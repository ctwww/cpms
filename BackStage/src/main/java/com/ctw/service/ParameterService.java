package com.ctw.service;

import java.util.List;

import com.ctw.bean.Parameter;

public interface ParameterService {

	String addAParameter(Parameter parameter);

	String deleteAParameter(Parameter parameter);

	String deleteAllParameter(Parameter parameter);

	List<Parameter> getParameterListByLink(Parameter p);

	String Parameterlist2Json(List<Parameter> list);

}
