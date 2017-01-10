package model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import util.Ret;

public interface Action {
	 Ret doAction(
	        HttpServletRequest request,
    		HttpServletResponse response,
    		Object shiroUser,PVoParamI param) throws Exception;
}
