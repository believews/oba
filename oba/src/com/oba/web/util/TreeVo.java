package com.oba.web.util;

public class TreeVo {
	private Long id;
	private Long pId;
	private String name;
	private String pname;
	private String tkey;
	private Integer pkey;
	private Integer status;
	
	
	public Integer getPkey() {
		return pkey;
	}
	public void setPkey(Integer pkey) {
		this.pkey = pkey;
	}
	public String getTkey() {
		return tkey;
	}
	public void setTkey(String tkey) {
		this.tkey = tkey;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	

}
