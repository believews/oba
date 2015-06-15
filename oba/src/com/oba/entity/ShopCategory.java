package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * ShopCategory
 * @author ws
 */
public class ShopCategory extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Long shopId;	//shopId
	private java.lang.Long categorylv2Id;	//categorylv2Id

	public ShopCategory(){
	}

	public ShopCategory(
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
	public void setShopId(java.lang.Long value) {
		this.shopId = value;
	}
	
	public java.lang.Long getShopId() {
		return this.shopId;
	}
	public void setCategorylv2Id(java.lang.Long value) {
		this.categorylv2Id = value;
	}
	
	public java.lang.Long getCategorylv2Id() {
		return this.categorylv2Id;
	}

}

