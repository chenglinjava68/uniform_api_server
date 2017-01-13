package com.dos.bsapp.shiro;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dos.bsapp.model.PrimitiveUser;

import util.MD5;
import java.util.*;

@Component
public class ShiroDbRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

	private ShiroUserServiceI userService;

	public ShiroDbRealm setUserService(ShiroUserServiceI val ) {
	    userService = val;
	    return this;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordTokenEx token = (UsernamePasswordTokenEx) authcToken;
		String username = token.getUsername();
        if (username == null) {
        	logger.error("用户名不能为空");
            throw new AccountException("用户名不能为空");
        }
        
        try
        {
        	//PrimitiveUser userInfo = new PrimitiveUser(); // userInfo = userGetService.getBasicBy(token.getUsername(),token.getPassword(),token.getAddition());
            //ShiroUser su = new ShiroUser(userInfo.getId(),userInfo.getNick(),token.getAddition());
           throw new AccountException("XXWWWW");
           /*
            return new SimpleAuthenticationInfo(
                userService.createShiroUser(username, token.getPassword(),token.getAddition()),
                token.getPassword(),
                username);*/
        }
        catch(Exception e){
        	throw new AccountException("用户名登录失败");
        }
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		java.util.Map<String,List<String>> collect = userService.collectRolePermission(shiroUser);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for(String role : collect.get("role")){
		    info.addRole(role);
		}
		for(String permission : collect.get("permission")){
		    info.addStringPermission(permission);
		}
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		//该句作用是重写shiro的密码验证，让shiro用我自己的验证
        setCredentialsMatcher(new org.apache.shiro.authc.credential.SimpleCredentialsMatcher(){
            @Override
            public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
                   UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
                   //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
                   Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
                   //System.out.println("password is:"+token.getPassword() + "encrypted is :"+ tokenCredentials);
                   Object accountCredentials = getCredentials(info);
                   System.out.println("accountCredentials is:"+accountCredentials);
                   boolean matches = equals(tokenCredentials, accountCredentials);
                   return matches;
               }

               //将传进来密码加密方法
               private String encrypt(String data) {
                   String md5str = MD5.getMD5ofString(data);//这里可以选择自己的密码验证方式 比如 md5或者sha256等
                   return md5str;
               }
   });
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		private Integer id;
		private String  username;
		private Object  addition;
		
		public ShiroUser(Integer id, String username, Object addition){
			this.id = id;
			this.username = username;
			this.addition = addition;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Object getAddition() {
			return addition;
		}

		public void setAddition(Object addition) {
			this.addition = addition;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * 重载equals,只计算mobile;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			return this.id.equals(other.id);
		}
	}
}
