package com.ctw.mapper;

import java.util.List;

import com.ctw.bean.Parameter;

public interface ParameterMapper {

	List<Parameter> selectAllParameterByLink(Parameter parameter);

	void deleteParameterByLink(Parameter parameter);

	void deleteAParameter(Parameter parameter);

	Parameter selectAParameterByLinkAndParameter(Parameter parameter);

	void addAParameter(Parameter parameter);

}
