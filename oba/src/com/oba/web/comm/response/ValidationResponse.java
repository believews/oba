package com.oba.web.comm.response;

public class ValidationResponse {

	private String status;	//状态
	private String message;	//消息
	private String mydata;	//数据

	public ValidationResponse(String status, String message, String mydata) {
		this.status = status;
		this.message = message;
		this.mydata = mydata;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMydata() {
		return mydata;
	}

	public void setMydata(String mydata) {
		this.mydata = mydata;
	}
}
