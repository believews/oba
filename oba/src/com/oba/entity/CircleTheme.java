package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * CircleTheme
 * @author ws
 */
public class CircleTheme extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Long circleId;	//circleId
	private java.lang.String themeName;	//themeName
	private java.lang.String themeContent;	//themeContent
	private java.lang.Long createUserid;	//createUserid
	private java.util.Date createTime;	//createTime
	private Integer isHot;	//isHot
	private java.lang.Long sort;	//sort

	public CircleTheme(){
	}

	public CircleTheme(
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
	public void setCircleId(java.lang.Long value) {
		this.circleId = value;
	}
	
	public java.lang.Long getCircleId() {
		return this.circleId;
	}
	public void setThemeName(java.lang.String value) {
		this.themeName = value;
	}
	
	public java.lang.String getThemeName() {
		return this.themeName;
	}
	public void setThemeContent(java.lang.String value) {
		this.themeContent = value;
	}
	
	public java.lang.String getThemeContent() {
		return this.themeContent;
	}
	public void setCreateUserid(java.lang.Long value) {
		this.createUserid = value;
	}
	
	public java.lang.Long getCreateUserid() {
		return this.createUserid;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setIsHot(Integer value) {
		this.isHot = value;
	}
	
	public Integer getIsHot() {
		return this.isHot;
	}
	public void setSort(java.lang.Long value) {
		this.sort = value;
	}
	
	public java.lang.Long getSort() {
		return this.sort;
	}

}

