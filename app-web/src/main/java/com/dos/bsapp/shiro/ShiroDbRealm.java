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

import org.apache.shiro.authc.*;
import util.MD5;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ShiroDbRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UserTypeNamePasswordToken token = (UserTypeNamePasswordToken) authcToken;
		String domain = token.getDomain();
		String username = token.getUsername();
        if (username == null) {
        	logger.error("用户名不能为空");
            throw new AccountException("用户名不能为空");
        }
        if(token.getUserType().equals("user")){
        	com.intelgoo.qqvisa.po.UserPo user =  accountService.findUserByLoginNameSimple(domain,token.getUsername());
        	ShiroUser su = new ShiroUser(domain,user.getId(),"user", user.getName(), user.getEmail(), user.getMobile(),
					user.getRole(), user.getEmEnterpriseId(),user.getBelong());
        	su.dr = user.getDr();

        	return new SimpleAuthenticationInfo(su,user.getPassword(),getName());
        }
        if(token.getUserType().equals("manager")){
        	com.intelgoo.qqvisa.model.Manager user =  accountService.findManagerByLoginNameSimple(token.getUsername());
        	ShiroUser su = new ShiroUser(domain,user.getId(),"manager", user.getName(),"", user.getMobile(),user.getRole(), 0, user.getBelong());

        	return new SimpleAuthenticationInfo(su,user.getPassword(),getName());
        }
        if(token.getUserType().equals("sdmanager")){
        	SubDomain subDomain =  domainService.getByUserName(username);
        	ShiroUser su = new ShiroUser(subDomain.getDomain(),
        			subDomain.getId().longValue(),
        			"sdmanager",
        			subDomain.getUserName(),
        			"", subDomain.getContactsMobile(),"sdmanager", 0, "global");

        	return new SimpleAuthenticationInfo(su,subDomain.getPassword(),getName());
        }
        throw new AccountException("用户名登录失败");
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();

		com.intelgoo.qqvisa.po.UserPo user =  accountService.findUserByLoginNameSimple(shiroUser.domain,shiroUser.mobile);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(user.getRole());
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		//该句作用是重写shiro的密码验证，让shiro用我自己的验证
        setCredentialsMatcher(new org.apache.shiro.authc.credential.CredentialsMatcher(){
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
		public String domain;
		public Long id;
		public String email;
		public String name;
		public String mobile;
		public String role;
		public Integer emEnterpriseId;
		private String userType;
		public String belong;
		public String dr = "n";

		public boolean useVspRawPrice(){

			if(domain == null)
				domain = "woigo";
			if(dr == null)
				dr = "n";
			return !domain.equals("woigo") && dr.equals("y");
		}

		public ShiroUser(String domain,Long id, String userType, String name, String email, String mobile, String role, Integer emEnterpriseId,String belong) {
			this.domain = domain;
			this.id = id;
			this.email = email;
			this.name = name;
			this.mobile = mobile;
			this.role = role;
			this.emEnterpriseId = emEnterpriseId;
			this.userType = userType;
			this.belong = belong;
		}

		public void setUserType(String val){
			assert("user".equals(val) || "manager".equals(val));
			this.userType = val;
		}
		public boolean isUser(){
			return "user".equals(this.userType);
		}
		public boolean isManager(){
			return "manager".equals(this.userType);
		}
		public boolean isSdManager(){
        	return "sdmanager".equals(this.userType);
       	}

		public boolean isAdmin(){
			return "manager".equals(this.userType) && "admin".equals(this.role.toLowerCase());
		}

		public String getName() {
			if(this.name==null)
				return this.mobile;
			else
				return this.name;
		}
		public String getUserType(){
			return this.userType;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return name;
		}

		/**
		 * 重载hashCode,只计算mobile;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(mobile);
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
			if (mobile == null) {
				if (other.mobile != null) {
					return false;
				}
			} else if (!mobile.equals(other.mobile)) {
				return false;
			}
			if(!domain.equals(other.domain))
				return false;
			return true;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Integer getEmEnterpriseId() {
			return emEnterpriseId;
		}

		public void setEmEnterpriseId(Integer emEnterpriseId) {
			this.emEnterpriseId = emEnterpriseId;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	}
}
