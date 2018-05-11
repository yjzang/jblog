package com.javaex.vo;

public class BlogVO {
	
	String id ;
	String blogtitle;
	String logofile;
	String username;
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	


	public String getBlogtitle() {
		return blogtitle;
	}



	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}



	public String getLogofile() {
		return logofile;
	}



	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "BlogVO [id=" + id + ", blogtitle=" + blogtitle + ", logofile=" + logofile + ", username=" + username
				+ "]";
	}




	
	
	 
}
