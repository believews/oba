package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Comment
 * @author ws
 */
public class Comment extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Long userId;	//userId
	private java.lang.Integer shopId;	//shopId
	private java.lang.String contents;	//contents
	private java.util.Date createTime;	//createTime
	private java.lang.Double star;	//星级 5:好评 3:中评 1:差评
	private java.lang.Double scoreSkill;	//技能得分
	private java.lang.Double scoreCommunication;	//沟通得分
	private java.lang.Double scorePunctuality;	//守时得分
	private java.lang.String orderSeq;	//订单号，一个订单只能评一次技师
	private java.lang.Integer praiseCount;	//praiseCount
	private java.lang.Integer punishmentCount;	//punishmentCount
	private java.lang.String isAvailability;	//1：有效             0：无效
	private java.lang.String isDel;	//1：有效             0：无效
	private java.lang.Integer modifyCount;	//modifyCount
	private java.lang.String userIp;	//userIp
	private java.lang.String userFrom;	//userFrom
	private java.util.Date updateTime;	//updateTime

	public Comment(){
	}

	public Comment(
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
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
	
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	public void setContents(java.lang.String value) {
		this.contents = value;
	}
	
	public java.lang.String getContents() {
		return this.contents;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setStar(java.lang.Double value) {
		this.star = value;
	}
	
	public java.lang.Double getStar() {
		return this.star;
	}
	public void setScoreSkill(java.lang.Double value) {
		this.scoreSkill = value;
	}
	
	public java.lang.Double getScoreSkill() {
		return this.scoreSkill;
	}
	public void setScoreCommunication(java.lang.Double value) {
		this.scoreCommunication = value;
	}
	
	public java.lang.Double getScoreCommunication() {
		return this.scoreCommunication;
	}
	public void setScorePunctuality(java.lang.Double value) {
		this.scorePunctuality = value;
	}
	
	public java.lang.Double getScorePunctuality() {
		return this.scorePunctuality;
	}
	public void setOrderSeq(java.lang.String value) {
		this.orderSeq = value;
	}
	
	public java.lang.String getOrderSeq() {
		return this.orderSeq;
	}
	public void setPraiseCount(java.lang.Integer value) {
		this.praiseCount = value;
	}
	
	public java.lang.Integer getPraiseCount() {
		return this.praiseCount;
	}
	public void setPunishmentCount(java.lang.Integer value) {
		this.punishmentCount = value;
	}
	
	public java.lang.Integer getPunishmentCount() {
		return this.punishmentCount;
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
	public void setModifyCount(java.lang.Integer value) {
		this.modifyCount = value;
	}
	
	public java.lang.Integer getModifyCount() {
		return this.modifyCount;
	}
	public void setUserIp(java.lang.String value) {
		this.userIp = value;
	}
	
	public java.lang.String getUserIp() {
		return this.userIp;
	}
	public void setUserFrom(java.lang.String value) {
		this.userFrom = value;
	}
	
	public java.lang.String getUserFrom() {
		return this.userFrom;
	}
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

}

