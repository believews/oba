package com.oba.entity;

import com.oba.web.util.BaseEntity;
 

/**
 * SecondComment
 * @author ws
 */
public class SecondComment extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private java.lang.Long id;	//id
	private java.lang.Long commentId;	//commentId
	private java.lang.Long userId;	//userId
	private java.lang.String nick;	//nick
	private java.lang.String headerpic;	//headerpic
	private java.lang.String comment;	//comment
	private java.util.Date createTime;	//createTime

	public SecondComment(){
	}

	

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setCommentId(java.lang.Long value) {
		this.commentId = value;
	}
	
	public java.lang.Long getCommentId() {
		return this.commentId;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setNick(java.lang.String value) {
		this.nick = value;
	}
	
	public java.lang.String getNick() {
		return this.nick;
	}
	public void setHeaderpic(java.lang.String value) {
		this.headerpic = value;
	}
	
	public java.lang.String getHeaderpic() {
		return this.headerpic;
	}
	public void setComment(java.lang.String value) {
		this.comment = value;
	}
	
	public java.lang.String getComment() {
		return this.comment;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

}

