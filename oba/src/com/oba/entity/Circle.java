package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Circle
 * @author ws
 */
public class Circle extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.String categoryName;	//categoryName
	private java.lang.String categoryLogo;	//categoryLogo
	private java.lang.Integer city;	//city
	private java.lang.Integer status;	//status
	private java.lang.Integer activityDegree;	//activityDegree
	private java.util.Date createTime;	//createTime
	private java.lang.String remark;	//remark

	public Circle(){
	}

	public Circle(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setCategoryName(java.lang.String value) {
		this.categoryName = value;
	}
	
	public java.lang.String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryLogo(java.lang.String value) {
		this.categoryLogo = value;
	}
	
	public java.lang.String getCategoryLogo() {
		return this.categoryLogo;
	}
	public void setCity(java.lang.Integer value) {
		this.city = value;
	}
	
	public java.lang.Integer getCity() {
		return this.city;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setActivityDegree(java.lang.Integer value) {
		this.activityDegree = value;
	}
	
	public java.lang.Integer getActivityDegree() {
		return this.activityDegree;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

