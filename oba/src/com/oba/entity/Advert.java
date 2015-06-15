package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Advert
 * @author ws
 */
public class Advert extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Integer adId;	//adId
	private java.lang.String adCity;	//adCity
	private java.lang.String adUrl;	//adUrl
	private java.lang.Integer adSort;	//adSort
	private java.lang.String adLink;	//adLink
	private java.lang.String adType;	//adType
	private java.lang.String adTitle;	//adTitle
	private java.lang.String adSearch;	//adSearch
	private java.lang.String adBegin;	//adBegin
	private java.lang.String adEnd;	//adEnd
	private java.lang.String adRemark;	//adRemark
	private java.lang.Integer adUsed;	//adUsed
	private java.util.Date adCreateTime;	//adCreateTime
	private java.lang.Integer adVersion;	//adVersion

	public Advert(){
	}

	public Advert(
		java.lang.Integer adId
	){
		this.adId = adId;
	}

	public void setAdId(java.lang.Integer value) {
		this.adId = value;
	}
	
	public java.lang.Integer getAdId() {
		return this.adId;
	}
	public void setAdCity(java.lang.String value) {
		this.adCity = value;
	}
	
	public java.lang.String getAdCity() {
		return this.adCity;
	}
	public void setAdUrl(java.lang.String value) {
		this.adUrl = value;
	}
	
	public java.lang.String getAdUrl() {
		return this.adUrl;
	}
	public void setAdSort(java.lang.Integer value) {
		this.adSort = value;
	}
	
	public java.lang.Integer getAdSort() {
		return this.adSort;
	}
	public void setAdLink(java.lang.String value) {
		this.adLink = value;
	}
	
	public java.lang.String getAdLink() {
		return this.adLink;
	}
	public void setAdType(java.lang.String value) {
		this.adType = value;
	}
	
	public java.lang.String getAdType() {
		return this.adType;
	}
	public void setAdTitle(java.lang.String value) {
		this.adTitle = value;
	}
	
	public java.lang.String getAdTitle() {
		return this.adTitle;
	}
	public void setAdSearch(java.lang.String value) {
		this.adSearch = value;
	}
	
	public java.lang.String getAdSearch() {
		return this.adSearch;
	}
	public void setAdBegin(java.lang.String value) {
		this.adBegin = value;
	}
	
	public java.lang.String getAdBegin() {
		return this.adBegin;
	}
	public void setAdEnd(java.lang.String value) {
		this.adEnd = value;
	}
	
	public java.lang.String getAdEnd() {
		return this.adEnd;
	}
	public void setAdRemark(java.lang.String value) {
		this.adRemark = value;
	}
	
	public java.lang.String getAdRemark() {
		return this.adRemark;
	}
	public void setAdUsed(java.lang.Integer value) {
		this.adUsed = value;
	}
	
	public java.lang.Integer getAdUsed() {
		return this.adUsed;
	}
	public void setAdCreateTime(java.util.Date value) {
		this.adCreateTime = value;
	}
	
	public java.util.Date getAdCreateTime() {
		return this.adCreateTime;
	}
	public void setAdVersion(java.lang.Integer value) {
		this.adVersion = value;
	}
	
	public java.lang.Integer getAdVersion() {
		return this.adVersion;
	}

}

