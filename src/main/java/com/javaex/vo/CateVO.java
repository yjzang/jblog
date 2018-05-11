package com.javaex.vo;

public class CateVO {

	
	String cateNo;
	String id;
	String cateName;
	String desc;
	String regDate;
	String postCount;
	
	
	
	
	public String getPostCount() {
		return postCount;
	}
	public void setPostCount(String postCount) {
		this.postCount = postCount;
	}
	public String getCateNo() {
		return cateNo;
	}
	public void setCateNo(String cateNo) {
		this.cateNo = cateNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "CateVO [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", desc=" + desc + ", regDate="
				+ regDate + "]";
	}
	
	
	
	
	
}
