package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * Dept
 * @author ws
 */
public class Dept extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Integer id;	//id
	private java.lang.String deptName;	//deptName
	private java.lang.Integer isDelete;	//isDelete
	private java.lang.Integer pid;	//pid
	private java.util.Date createTime;	//createTime

	public Dept(){
	}

	public Dept(
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
	public void setDeptName(java.lang.String value) {
		this.deptName = value;
	}
	
	public java.lang.String getDeptName() {
		return this.deptName;
	}
	public void setIsDelete(java.lang.Integer value) {
		this.isDelete = value;
	}
	
	public java.lang.Integer getIsDelete() {
		return this.isDelete;
	}
	public void setPid(java.lang.Integer value) {
		this.pid = value;
	}
	
	public java.lang.Integer getPid() {
		return this.pid;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

}

