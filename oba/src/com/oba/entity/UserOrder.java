package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * UserOrder
 * @author ws
 */
public class UserOrder extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.String orderSeq;	//orderSeq
	private java.lang.Integer source;	//1微信2客服下单3android下单4.ios下单
	private java.lang.Integer city;	//city
	private java.lang.Integer payType;	//1,现金支付，2、刷卡支付，3、微信支付，4、支付宝支付、5，银联支付
	private Long shouldPay;	//shouldPay
	private Long realPay;	//realPay
	private java.lang.Long userId;	//userId
	private java.lang.Long productId;	//productId
	private java.lang.Long addressId;	//addressId
	private java.lang.String mobile;	//mobile
	private java.lang.String address;	//address
	private java.lang.String artisanId;	//artisanId
	private java.lang.Integer status;	//0新建1确认2取消3无效4退货5退款6完成7进行中( 开始服务)8待评价
	private java.lang.Integer ifChoose;	//是否分配技师0没有1有
	private java.lang.Integer payStatus;	//payStatus
	private java.lang.Long couponId;	//couponId
	private java.util.Date createTime;	//createTime
	private java.util.Date reserveTime;	//reserveTime
	private java.util.Date payTime;	//payTime
	private java.lang.Integer artisanStatus;	//技师状态（0：分配技师，1: 确认订单 2,已出发）
	private java.util.Date artisanConfirmTime;	//artisanConfirmTime
	private java.util.Date customConfirmTime;	//customConfirmTime
	private java.util.Date refundTime;	//refundTime
	private Long refundMoney;	//refundMoney
	private java.lang.String remark;	//remark
	private java.lang.Integer type;	//订单类型1大保养2小保养
	private java.lang.Long createId;	//createId
	private java.lang.Integer orderType;	//1上门接车2到店维修3到店保养4自主预约
	private Long servicePay;	//servicePay

	public UserOrder(){
	}

	public UserOrder(
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
	public void setOrderSeq(java.lang.String value) {
		this.orderSeq = value;
	}
	
	public java.lang.String getOrderSeq() {
		return this.orderSeq;
	}
	public void setSource(java.lang.Integer value) {
		this.source = value;
	}
	
	public java.lang.Integer getSource() {
		return this.source;
	}
	public void setCity(java.lang.Integer value) {
		this.city = value;
	}
	
	public java.lang.Integer getCity() {
		return this.city;
	}
	public void setPayType(java.lang.Integer value) {
		this.payType = value;
	}
	
	public java.lang.Integer getPayType() {
		return this.payType;
	}
	public void setShouldPay(Long value) {
		this.shouldPay = value;
	}
	
	public Long getShouldPay() {
		return this.shouldPay;
	}
	public void setRealPay(Long value) {
		this.realPay = value;
	}
	
	public Long getRealPay() {
		return this.realPay;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public void setAddressId(java.lang.Long value) {
		this.addressId = value;
	}
	
	public java.lang.Long getAddressId() {
		return this.addressId;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setArtisanId(java.lang.String value) {
		this.artisanId = value;
	}
	
	public java.lang.String getArtisanId() {
		return this.artisanId;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIfChoose(java.lang.Integer value) {
		this.ifChoose = value;
	}
	
	public java.lang.Integer getIfChoose() {
		return this.ifChoose;
	}
	public void setPayStatus(java.lang.Integer value) {
		this.payStatus = value;
	}
	
	public java.lang.Integer getPayStatus() {
		return this.payStatus;
	}
	public void setCouponId(java.lang.Long value) {
		this.couponId = value;
	}
	
	public java.lang.Long getCouponId() {
		return this.couponId;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setReserveTime(java.util.Date value) {
		this.reserveTime = value;
	}
	
	public java.util.Date getReserveTime() {
		return this.reserveTime;
	}
	public void setPayTime(java.util.Date value) {
		this.payTime = value;
	}
	
	public java.util.Date getPayTime() {
		return this.payTime;
	}
	public void setArtisanStatus(java.lang.Integer value) {
		this.artisanStatus = value;
	}
	
	public java.lang.Integer getArtisanStatus() {
		return this.artisanStatus;
	}
	public void setArtisanConfirmTime(java.util.Date value) {
		this.artisanConfirmTime = value;
	}
	
	public java.util.Date getArtisanConfirmTime() {
		return this.artisanConfirmTime;
	}
	public void setCustomConfirmTime(java.util.Date value) {
		this.customConfirmTime = value;
	}
	
	public java.util.Date getCustomConfirmTime() {
		return this.customConfirmTime;
	}
	public void setRefundTime(java.util.Date value) {
		this.refundTime = value;
	}
	
	public java.util.Date getRefundTime() {
		return this.refundTime;
	}
	public void setRefundMoney(Long value) {
		this.refundMoney = value;
	}
	
	public Long getRefundMoney() {
		return this.refundMoney;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setCreateId(java.lang.Long value) {
		this.createId = value;
	}
	
	public java.lang.Long getCreateId() {
		return this.createId;
	}
	public void setOrderType(java.lang.Integer value) {
		this.orderType = value;
	}
	
	public java.lang.Integer getOrderType() {
		return this.orderType;
	}
	public void setServicePay(Long value) {
		this.servicePay = value;
	}
	
	public Long getServicePay() {
		return this.servicePay;
	}

}

