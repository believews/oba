package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * UserSuggest
 * @author ws
 */
public class UserSuggest extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Integer id;	//id
	private java.lang.Integer customId;	//customId
	private java.lang.String mobile;	//mobile
	private java.lang.String suggestion;	//suggestion
	private java.lang.Integer status;	//status
	private java.util.Date createTime;	//createTime
	private java.lang.String reply;	//reply
	private java.lang.String remark;	//remark

	public UserSuggest(){
	}

	public UserSuggest(
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
	public void setCustomId(java.lang.Integer value) {
		this.customId = value;
	}
	
	public java.lang.Integer getCustomId() {
		return this.customId;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setSuggestion(java.lang.String value) {
		this.suggestion = value;
	}
	
	public java.lang.String getSuggestion() {
		return this.suggestion;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setReply(java.lang.String value) {
		this.reply = value;
	}
	
	public java.lang.String getReply() {
		return this.reply;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

