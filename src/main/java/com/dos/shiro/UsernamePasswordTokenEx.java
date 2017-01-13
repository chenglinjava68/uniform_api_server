package com.dos.shiro;

public class UsernamePasswordTokenEx extends org.apache.shiro.authc.UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181502590494044064L;
	private Object addition;	
	
	public Object getAddition() {
		return addition;
	}
	public void setAddition(Object addition) {
		this.addition = addition;
	}


	public UsernamePasswordTokenEx(final String username, final String password,Object oddition){
		super(username,password);
		this.addition = oddition;
	}
}
