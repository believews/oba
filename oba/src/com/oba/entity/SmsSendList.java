package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * SmsSendList
 * @author ws
 */
public class SmsSendList extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//主键
	private java.lang.String msgSeq;	//msgSeq
	private java.lang.String busiType;	//000000：普通通知             000100：新用户注册             000200：发送新的验证码
	private java.lang.String mobile;	//mobile
	private java.lang.String sendCode;	//sendCode
	private java.lang.String msg;	//msg
	private java.lang.String beginTime;	//beginTime
	private java.lang.String endTime;	//endTime
	private java.lang.String isDeal;	//00：不用处理             01：未处理             11：已处理
	private java.util.Date createTime;	//createTime
	private java.lang.String createUserId;	//createUserId
	private java.util.Date updateTime;	//updateTime
	private java.lang.String updateUserId;	//updateUserId
	private java.lang.String isAvailability;	//1：有效             0：无效
	private java.lang.String isDel;	//0：未删除             1：删除

	public SmsSendList(){
	}

	public SmsSendList(
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
	public void setMsgSeq(java.lang.String value) {
		this.msgSeq = value;
	}
	
	public java.lang.String getMsgSeq() {
		return this.msgSeq;
	}
	public void setBusiType(java.lang.String value) {
		this.busiType = value;
	}
	
	public java.lang.String getBusiType() {
		return this.busiType;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setSendCode(java.lang.String value) {
		this.sendCode = value;
	}
	
	public java.lang.String getSendCode() {
		return this.sendCode;
	}
	public void setMsg(java.lang.String value) {
		this.msg = value;
	}
	
	public java.lang.String getMsg() {
		return this.msg;
	}
	public void setBeginTime(java.lang.String value) {
		this.beginTime = value;
	}
	
	public java.lang.String getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(java.lang.String value) {
		this.endTime = value;
	}
	
	public java.lang.String getEndTime() {
		return this.endTime;
	}
	public void setIsDeal(java.lang.String value) {
		this.isDeal = value;
	}
	
	public java.lang.String getIsDeal() {
		return this.isDeal;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateUserId(java.lang.String value) {
		this.createUserId = value;
	}
	
	public java.lang.String getCreateUserId() {
		return this.createUserId;
	}
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateUserId(java.lang.String value) {
		this.updateUserId = value;
	}
	
	public java.lang.String getUpdateUserId() {
		return this.updateUserId;
	}
	public void setIsAvailability(java.lang.String value) {
		this.isAvailability = value;
	}
	
	public java.lang.String getIsAvailability() {
		return this.isAvailability;
	}
	public void setIsDel(java.lang.String value) {
		this.isDel = value;
	}
	
	public java.lang.String getIsDel() {
		return this.isDel;
	}

}

