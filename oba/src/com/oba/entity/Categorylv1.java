package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Categorylv1
 * @author ws
 */
public class Categorylv1 extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long categorylv1Id;	//categorylv1Id
	private java.lang.String categoryName;	//categoryName
	private java.lang.Integer city;	//city
	private Integer status;	//status
	private java.lang.String imgType;	//imgType
	private java.util.Date createTime;	//createTime
	private java.lang.String remark;	//remark

	public Categorylv1(){
	}

	public Categorylv1(
		java.lang.Long categorylv1Id
	){
		this.categorylv1Id = categorylv1Id;
	}

	public void setCategorylv1Id(java.lang.Long value) {
		this.categorylv1Id = value;
	}
	
	public java.lang.Long getCategorylv1Id() {
		return this.categorylv1Id;
	}
	public void setCategoryName(java.lang.String value) {
		this.categoryName = value;
	}
	
	public java.lang.String getCategoryName() {
		return this.categoryName;
	}
	public void setCity(java.lang.Integer value) {
		this.city = value;
	}
	
	public java.lang.Integer getCity() {
		return this.city;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	public void setImgType(java.lang.String value) {
		this.imgType = value;
	}
	
	public java.lang.String getImgType() {
		return this.imgType;
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

