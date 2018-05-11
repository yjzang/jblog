package com.javaex.vo;

public class CmtVO {

	String cmtNo;
	String postNo;
	String userNo;
	String cmtContent;
	String regdate;

	
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "CmtVO [cmtNo=" + cmtNo + ", postNo=" + postNo + ", userNo=" + userNo + ", cmtContent=" + cmtContent
				+ ", regdate=" + regdate + "]";
	}
	
	
	
	
}
