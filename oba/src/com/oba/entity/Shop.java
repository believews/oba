package com.oba.entity;

import com.oba.web.util.BaseEntity;

/**
 * Shop
 * 
 * @author ws
 */
public class Shop extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.Integer shopId; // shopId
	private java.lang.String contact; // contact
	private java.lang.String shopName; // shopName
	private java.lang.Integer status; // 1：正常 0：新建 2：注销
	private java.lang.String avatar; // avatar
	private java.lang.Double averagePrice; // averagePrice
	private java.lang.Double serviceAmount; // serviceAmount
	private java.lang.Double star; // star
	private java.lang.Double scoreSkill; // scoreSkill
	private java.lang.Double scoreCommunication; // scoreCommunication
	private java.lang.Double scorePunctuality; // scorePunctuality
	private java.lang.String serviceContent; // serviceContent
	private java.lang.String des; // 服务范围
	private java.lang.String password; // password
	private java.lang.Integer commentCount; // commentCount
	private java.lang.String address; // address
	private java.util.Date createTime; // createTime
	private java.util.Date updateTime; // updateTime
	private java.lang.String searchKey; // searchKey
	private java.lang.String remark; // remark

	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Shop() {
	}

	public Shop(java.lang.Integer shopId) {
		this.shopId = shopId;
	}

	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}

	public java.lang.Integer getShopId() {
		return this.shopId;
	}

	public void setContact(java.lang.String value) {
		this.contact = value;
	}

	public java.lang.String getContact() {
		return this.contact;
	}

	public void setShopName(java.lang.String value) {
		this.shopName = value;
	}

	public java.lang.String getShopName() {
		return this.shopName;
	}

	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setAvatar(java.lang.String value) {
		this.avatar = value;
	}

	public java.lang.String getAvatar() {
		return this.avatar;
	}

	public void setAveragePrice(java.lang.Double value) {
		this.averagePrice = value;
	}

	public java.lang.Double getAveragePrice() {
		return this.averagePrice;
	}

	public void setServiceAmount(java.lang.Double value) {
		this.serviceAmount = value;
	}

	public java.lang.Double getServiceAmount() {
		return this.serviceAmount;
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

	public void setServiceContent(java.lang.String value) {
		this.serviceContent = value;
	}

	public java.lang.String getServiceContent() {
		return this.serviceContent;
	}

	public void setDes(java.lang.String value) {
		this.des = value;
	}

	public java.lang.String getDes() {
		return this.des;
	}

	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	public java.lang.String getPassword() {
		return this.password;
	}

	public void setCommentCount(java.lang.Integer value) {
		this.commentCount = value;
	}

	public java.lang.Integer getCommentCount() {
		return this.commentCount;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setSearchKey(java.lang.String value) {
		this.searchKey = value;
	}

	public java.lang.String getSearchKey() {
		return this.searchKey;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

}
