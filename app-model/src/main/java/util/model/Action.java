package util.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intelgoo.qqvisa.plugin.shiro.ShiroDbRealm.ShiroUser;

import util.Ret;

public interface Action {
	 Ret doAction(
	        HttpServletRequest request,
    		HttpServletResponse response,
    		ShiroUser u,PVoParamI param) throws Exception;
}
