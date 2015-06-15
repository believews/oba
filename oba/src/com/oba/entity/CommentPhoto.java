package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * CommentPhoto
 * @author ws
 */
public class CommentPhoto extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Long commId;	//commId
	private java.lang.String photo;	//photo
	private java.util.Date createTime;	//createTime
	private java.lang.Integer yesNum;	//yesNum
	private java.lang.Long userId;	//userId

	public CommentPhoto(){
	}

	public CommentPhoto(
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
	public void setCommId(java.lang.Long value) {
		this.commId = value;
	}
	
	public java.lang.Long getCommId() {
		return this.commId;
	}
	public void setPhoto(java.lang.String value) {
		this.photo = value;
	}
	
	public java.lang.String getPhoto() {
		return this.photo;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setYesNum(java.lang.Integer value) {
		this.yesNum = value;
	}
	
	public java.lang.Integer getYesNum() {
		return this.yesNum;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}

}

