package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * UserAddress
 * @author ws
 */
public class UserAddress extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Integer ifComm;	//ifComm
	private java.lang.Long customId;	//customId
	private java.lang.String customName;	//customName
	private java.lang.String mobile;	//mobile
	private java.lang.Integer province;	//province
	private java.lang.Integer city;	//city
	private java.lang.Integer town;	//town
	private java.lang.String addressPoi;	//定位地址
	private java.lang.String address;	//address
	private Long longitude;	//longitude
	private Long latitude;	//latitude
	private java.util.Date createTime;	//createTime
	private java.lang.Integer isDelete;	//isDelete
	private java.lang.Integer status;	//0启用，1停用

	public UserAddress(){
	}

	public UserAddress(
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
	public void setIfComm(java.lang.Integer value) {
		this.ifComm = value;
	}
	
	public java.lang.Integer getIfComm() {
		return this.ifComm;
	}
	public void setCustomId(java.lang.Long value) {
		this.customId = value;
	}
	
	public java.lang.Long getCustomId() {
		return this.customId;
	}
	public void setCustomName(java.lang.String value) {
		this.customName = value;
	}
	
	public java.lang.String getCustomName() {
		return this.customName;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setProvince(java.lang.Integer value) {
		this.province = value;
	}
	
	public java.lang.Integer getProvince() {
		return this.province;
	}
	public void setCity(java.lang.Integer value) {
		this.city = value;
	}
	
	public java.lang.Integer getCity() {
		return this.city;
	}
	public void setTown(java.lang.Integer value) {
		this.town = value;
	}
	
	public java.lang.Integer getTown() {
		return this.town;
	}
	public void setAddressPoi(java.lang.String value) {
		this.addressPoi = value;
	}
	
	public java.lang.String getAddressPoi() {
		return this.addressPoi;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setLongitude(Long value) {
		this.longitude = value;
	}
	
	public Long getLongitude() {
		return this.longitude;
	}
	public void setLatitude(Long value) {
		this.latitude = value;
	}
	
	public Long getLatitude() {
		return this.latitude;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setIsDelete(java.lang.Integer value) {
		this.isDelete = value;
	}
	
	public java.lang.Integer getIsDelete() {
		return this.isDelete;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}

}

