package com.dos.bsapp.shiro;

public class UserTypeNamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181502590494044064L;
	private String userType;
	public String getUserType() { return this.userType; }
	public void setUserType(String val){ this.userType = val; }

	private String domain = "woigo";
	public String getDomain() { return this.domain; }
	public void setDomain(String val){ domain = val; }
	
	public UserTypeNamePasswordToken(){
		this.userType = "user";
	}
	public UserTypeNamePasswordToken(String domain,final String username, final String password) {
        super(username,password);
        this.domain = domain;
        if(this.domain == null || this.domain == "")
        	this.domain = "woigo";
        this.userType = "user";
    }
	public UserTypeNamePasswordToken(String domain,final String username, final char[] password) {
        super(username,password);
        this.domain = domain;
                if(this.domain == null || this.domain == "")
                	this.domain = "woigo";
        this.userType = "user";
    }
	public UserTypeNamePasswordToken(String domain,final String username, final String password, String userType) {
        super(username,password);
        this.domain = domain;
                if(this.domain == null || this.domain == "")
                	this.domain = "woigo";
        if(userType == null )
        	this.userType = "user";
        else
        	this.userType = userType;
    }
	public UserTypeNamePasswordToken(String domain,final String username, final char[] password, String userType) {
        super(username,password);
        this.domain = domain;
                if(this.domain == null || this.domain == "")
                	this.domain = "woigo";
        if(userType == null )
        	this.userType = "user";
        else
        	this.userType = userType;
    }
}
