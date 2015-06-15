package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * City
 * @author ws
 */
public class City extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Integer id;	//id
	private java.lang.String cityCode;	//cityCode
	private java.lang.String cityName;	//cityName
	private java.lang.String cityAreaCode;	//cityAreaCode
	private java.lang.String cityPostCode;	//cityPostCode
	private java.lang.Integer cityLevel;	//cityLevel
	private java.lang.String parentCode;	//parentCode
	private java.lang.Integer enableStatus;	//enableStatus
	private java.lang.String other1;	//other1
	private java.lang.String other2;	//other2
	private java.lang.String other3;	//other3
	private java.lang.String other4;	//other4
	private java.lang.String other5;	//other5

	public City(){
	}

	public City(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	public void setCityName(java.lang.String value) {
		this.cityName = value;
	}
	
	public java.lang.String getCityName() {
		return this.cityName;
	}
	public void setCityAreaCode(java.lang.String value) {
		this.cityAreaCode = value;
	}
	
	public java.lang.String getCityAreaCode() {
		return this.cityAreaCode;
	}
	public void setCityPostCode(java.lang.String value) {
		this.cityPostCode = value;
	}
	
	public java.lang.String getCityPostCode() {
		return this.cityPostCode;
	}
	public void setCityLevel(java.lang.Integer value) {
		this.cityLevel = value;
	}
	
	public java.lang.Integer getCityLevel() {
		return this.cityLevel;
	}
	public void setParentCode(java.lang.String value) {
		this.parentCode = value;
	}
	
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	public void setEnableStatus(java.lang.Integer value) {
		this.enableStatus = value;
	}
	
	public java.lang.Integer getEnableStatus() {
		return this.enableStatus;
	}
	public void setOther1(java.lang.String value) {
		this.other1 = value;
	}
	
	public java.lang.String getOther1() {
		return this.other1;
	}
	public void setOther2(java.lang.String value) {
		this.other2 = value;
	}
	
	public java.lang.String getOther2() {
		return this.other2;
	}
	public void setOther3(java.lang.String value) {
		this.other3 = value;
	}
	
	public java.lang.String getOther3() {
		return this.other3;
	}
	public void setOther4(java.lang.String value) {
		this.other4 = value;
	}
	
	public java.lang.String getOther4() {
		return this.other4;
	}
	public void setOther5(java.lang.String value) {
		this.other5 = value;
	}
	
	public java.lang.String getOther5() {
		return this.other5;
	}

}

