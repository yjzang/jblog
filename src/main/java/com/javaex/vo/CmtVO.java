package com.javaex.vo;

public class CmtVO {

	String cmtNo;
	String postNo;
	String userNo;
	String cmtContent;
	String regDate;
	String userName;

	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(String cmtNo) {
		this.cmtNo = cmtNo;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CmtVO [cmtNo=" + cmtNo + ", postNo=" + postNo + ", userNo=" + userNo + ", cmtContent=" + cmtContent
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	
}
