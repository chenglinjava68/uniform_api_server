package com.dos.model;

import com.dos.util.Ret;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	 Ret doAction(
             HttpServletRequest request,
             HttpServletResponse response,
             Object shiroUser, PVoParamI param) throws Exception;
}
