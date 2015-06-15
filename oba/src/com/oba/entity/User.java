package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * User
 * @author ws
 */
public class User extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//主键
	private java.lang.String name;	//姓名
	private java.lang.String mobile;	//手机号
	private java.lang.String nick;	//昵称
	private java.lang.String intro;	//用户说明
	private java.lang.String password;	//密码
	private java.lang.Integer status;	//用户状态 0：新建状态 1：注册正常(自动无审核)   2：审核通过   3: 审核不通过  4：业务暂停     5：注消用户   6：黑名单
	private java.lang.String sex;	//性别             -1：未设             0：男             1：女
	private java.lang.String headerpic;	//用户头像             http://
	private java.lang.String deviceInfo;	//设备信息
	private java.lang.String sysPlatform;	//系统平台：ios|android
	private java.lang.String mobileTypeNo;	//手机型号:
	private java.lang.String sysPlatVersion;	//系统平台版本号             例：an 4.1 ios7
	private java.lang.String imei;	//imei
	private java.lang.String token;	//用户token
	private java.util.Date tokenEndTime;	//用户时效
	private java.lang.String appVersion;	//软件版本号：             例： v1.1.1
	private java.lang.String openIdSrc;	//第三方用户注册系统标识
	private java.lang.String openId;	//第三方系统openid
	private java.lang.Integer isEmployee;	//是否页工 0：否 1：是
	private java.lang.String vipLevel;	//等级 '0':'普通','10':'一级','20':'二级','30':'三级','40':'三级','50':'最高级'
	private java.lang.String auditingCause;	//审核理由
	private java.lang.Integer province;	//省份
	private java.lang.Integer city;	//城市
	private java.lang.Integer towns;	//县城
	private java.lang.Integer pushStatus;	//pushStatus
	private java.lang.String channel;	//channel
	private Long point;	//积分
	private java.lang.String resource;	//来源
	private java.util.Date createTime;	//createTime
	private java.util.Date updateTime;	//updateTime

	public User(){
	}

	public User(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setNick(java.lang.String value) {
		this.nick = value;
	}
	
	public java.lang.String getNick() {
		return this.nick;
	}
	public void setIntro(java.lang.String value) {
		this.intro = value;
	}
	
	public java.lang.String getIntro() {
		return this.intro;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setHeaderpic(java.lang.String value) {
		this.headerpic = value;
	}
	
	public java.lang.String getHeaderpic() {
		return this.headerpic;
	}
	public void setDeviceInfo(java.lang.String value) {
		this.deviceInfo = value;
	}
	
	public java.lang.String getDeviceInfo() {
		return this.deviceInfo;
	}
	public void setSysPlatform(java.lang.String value) {
		this.sysPlatform = value;
	}
	
	public java.lang.String getSysPlatform() {
		return this.sysPlatform;
	}
	public void setMobileTypeNo(java.lang.String value) {
		this.mobileTypeNo = value;
	}
	
	public java.lang.String getMobileTypeNo() {
		return this.mobileTypeNo;
	}
	public void setSysPlatVersion(java.lang.String value) {
		this.sysPlatVersion = value;
	}
	
	public java.lang.String getSysPlatVersion() {
		return this.sysPlatVersion;
	}
	public void setImei(java.lang.String value) {
		this.imei = value;
	}
	
	public java.lang.String getImei() {
		return this.imei;
	}
	public void setToken(java.lang.String value) {
		this.token = value;
	}
	
	public java.lang.String getToken() {
		return this.token;
	}
	public void setTokenEndTime(java.util.Date value) {
		this.tokenEndTime = value;
	}
	
	public java.util.Date getTokenEndTime() {
		return this.tokenEndTime;
	}
	public void setAppVersion(java.lang.String value) {
		this.appVersion = value;
	}
	
	public java.lang.String getAppVersion() {
		return this.appVersion;
	}
	public void setOpenIdSrc(java.lang.String value) {
		this.openIdSrc = value;
	}
	
	public java.lang.String getOpenIdSrc() {
		return this.openIdSrc;
	}
	public void setOpenId(java.lang.String value) {
		this.openId = value;
	}
	
	public java.lang.String getOpenId() {
		return this.openId;
	}
	public void setIsEmployee(java.lang.Integer value) {
		this.isEmployee = value;
	}
	
	public java.lang.Integer getIsEmployee() {
		return this.isEmployee;
	}
	public void setVipLevel(java.lang.String value) {
		this.vipLevel = value;
	}
	
	public java.lang.String getVipLevel() {
		return this.vipLevel;
	}
	public void setAuditingCause(java.lang.String value) {
		this.auditingCause = value;
	}
	
	public java.lang.String getAuditingCause() {
		return this.auditingCause;
	}
	public void setProvince(java.lang.Integer value) {
		this.province = value;
	}
	
	public java.lang.Integer getProvince() {
		return this.province;
	}
	public void setCity(java.lang.Integer value) {
		this.city = value;
	}
	
	public java.lang.Integer getCity() {
		return this.city;
	}
	public void setTowns(java.lang.Integer value) {
		this.towns = value;
	}
	
	public java.lang.Integer getTowns() {
		return this.towns;
	}
	public void setPushStatus(java.lang.Integer value) {
		this.pushStatus = value;
	}
	
	public java.lang.Integer getPushStatus() {
		return this.pushStatus;
	}
	public void setChannel(java.lang.String value) {
		this.channel = value;
	}
	
	public java.lang.String getChannel() {
		return this.channel;
	}
	public void setPoint(Long value) {
		this.point = value;
	}
	
	public Long getPoint() {
		return this.point;
	}
	public void setResource(java.lang.String value) {
		this.resource = value;
	}
	
	public java.lang.String getResource() {
		return this.resource;
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

}

