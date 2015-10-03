package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册评论回复表持久化Bean类 <br>
 */
public class PhotoCommentReplyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer replyId; 			// 回复ID
	private Integer commentId;			// 评论ID
	private Integer replyKeeno;		// 回复人号码
	private String replyContent; 		// 评论内容
	private String replyDate; 			// 评论时间
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getReplyKeeno() {
		return replyKeeno;
	}
	public void setReplyKeeno(Integer replyKeeno) {
		this.replyKeeno = replyKeeno;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
}
