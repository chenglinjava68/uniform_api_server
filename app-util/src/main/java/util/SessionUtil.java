package util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.intelgoo.qqvisa.exception.UserNeedLoginException;
import com.intelgoo.qqvisa.plugin.shiro.ShiroDbRealm.ShiroUser;

public class SessionUtil {
	public static ShiroUser  getUserInfoByTokenOrSession() throws UserNeedLoginException{
		Subject currentUser = SecurityUtils.getSubject(); 
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		//todao1 check current user is a user, usertype = user
		
		if(user == null || (!user.isUser()))
			throw new UserNeedLoginException("当前操作需要登录，请登录。");
		return user;
	}


	public static ShiroUser  getSdManagerInfoByTokenOrSession() throws UserNeedLoginException{
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		//todao2 check current user is a manager ,user type = manager
		if(user == null || (!user.isSdManager()))
			throw new UserNeedLoginException("当前操作需要登录，请登录。");
		return user;
	}
	public static ShiroUser  getManagerInfoByTokenOrSession() throws UserNeedLoginException{
		Subject currentUser = SecurityUtils.getSubject(); 
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		//todao2 check current user is a manager ,user type = manager
		if(user == null || (!user.isManager()))
			throw new UserNeedLoginException("当前操作需要登录，请登录。");
		return user;
	}
	
	public static ShiroUser  getAdminInfoByTokenOrSession() throws UserNeedLoginException{
		Subject currentUser = SecurityUtils.getSubject(); 
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		//todao2 check current user is a manager ,user type = manager
		if(user == null || (!user.isManager()))
			throw new UserNeedLoginException("当前操作需要登录，请登录。");
		if(!user.isAdmin())
			throw new UserNeedLoginException("权限错误");
		return user;
	}
	
	public static ShiroUser getLoginInfo(){
		Subject currentUser = SecurityUtils.getSubject(); 
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		return user;
	}
	
	public static ShiroUser  getInfoByTokenOrSession() throws UserNeedLoginException{
		Subject currentUser = SecurityUtils.getSubject(); 
		ShiroUser user =  (ShiroUser)currentUser.getPrincipal();
		//todao2 check current user is a manager ,user type = manager
		if(user == null )
			throw new UserNeedLoginException("当前操作需要登录，请登录。");
		return user;
	}
}
