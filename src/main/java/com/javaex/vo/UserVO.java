package com.javaex.vo;

public class UserVO {

	
	String userno;
	String id;
	String username;
	String password;
	String joinDate;
	
	
	public String getUserno() {
		return userno;
	}


	public void setUserno(String userno) {
		this.userno = userno;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "UserVO [userno=" + userno + ", id=" + id + ", username=" + username + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}


	
	
}
