package com.liwangwang.entity;

public class t_user {
	
	private int user_id;
	private int user_name;
	private int user_pwd;
	private int user_type;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_name() {
		return user_name;
	}
	public void setUser_name(int user_name) {
		this.user_name = user_name;
	}
	public int getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(int user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public t_user(int user_id, int user_name, int user_pwd, int user_type) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_type = user_type;
	}
	public t_user(int user_name, int user_pwd, int user_type) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_type = user_type;
	}
	public t_user() {
		super();
	}
	
	

}
