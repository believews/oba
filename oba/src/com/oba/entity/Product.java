package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Product
 * @author ws
 */
public class Product extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.String productId;	//productId
	private java.lang.String productName;	//productName
	private java.lang.String picUrl;	//picUrl
	private Long price;	//price
	private java.lang.Integer sales;	//sales
	private java.lang.Integer serviceTime;	//serviceTime
	private java.lang.Integer shelfLife;	//shelfLife
	private java.lang.Integer recommendIndex;	//recommendIndex
	private java.lang.String productIntroduce;	//productIntroduce
	private java.lang.String productDetail;	//productDetail
	private java.util.Date createTime;	//createTime

	public Product(){
	}

	public Product(
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
	public void setProductId(java.lang.String value) {
		this.productId = value;
	}
	
	public java.lang.String getProductId() {
		return this.productId;
	}
	public void setProductName(java.lang.String value) {
		this.productName = value;
	}
	
	public java.lang.String getProductName() {
		return this.productName;
	}
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
	
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	public void setPrice(Long value) {
		this.price = value;
	}
	
	public Long getPrice() {
		return this.price;
	}
	public void setSales(java.lang.Integer value) {
		this.sales = value;
	}
	
	public java.lang.Integer getSales() {
		return this.sales;
	}
	public void setServiceTime(java.lang.Integer value) {
		this.serviceTime = value;
	}
	
	public java.lang.Integer getServiceTime() {
		return this.serviceTime;
	}
	public void setShelfLife(java.lang.Integer value) {
		this.shelfLife = value;
	}
	
	public java.lang.Integer getShelfLife() {
		return this.shelfLife;
	}
	public void setRecommendIndex(java.lang.Integer value) {
		this.recommendIndex = value;
	}
	
	public java.lang.Integer getRecommendIndex() {
		return this.recommendIndex;
	}
	public void setProductIntroduce(java.lang.String value) {
		this.productIntroduce = value;
	}
	
	public java.lang.String getProductIntroduce() {
		return this.productIntroduce;
	}
	public void setProductDetail(java.lang.String value) {
		this.productDetail = value;
	}
	
	public java.lang.String getProductDetail() {
		return this.productDetail;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

}

