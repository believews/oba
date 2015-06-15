package com.oba.entity;

import java.util.List;

import com.oba.web.util.BaseEntity;

/**
 * Categorylv1
 * 
 * @author ws
 */
public class Category extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.Long categorylv1Id; // categorylv1Id
	private java.lang.String categorylv1Name; // categoryName
	private java.lang.String imgType; // categoryName
	private List<Categorylv2> listCategorylv2;

	public java.lang.String getImgType() {
		return imgType;
	}

	public void setImgType(java.lang.String imgType) {
		this.imgType = imgType;
	}

	public java.lang.Long getCategorylv1Id() {
		return categorylv1Id;
	}

	public void setCategorylv1Id(java.lang.Long categorylv1Id) {
		this.categorylv1Id = categorylv1Id;
	}

	public java.lang.String getCategorylv1Name() {
		return categorylv1Name;
	}

	public void setCategorylv1Name(java.lang.String categorylv1Name) {
		this.categorylv1Name = categorylv1Name;
	}

	public List<Categorylv2> getListCategorylv2() {
		return listCategorylv2;
	}

	public void setListCategorylv2(List<Categorylv2> listCategorylv2) {
		this.listCategorylv2 = listCategorylv2;
	}

}
