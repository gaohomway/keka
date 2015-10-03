package com.keekan.action;

import java.util.List;

import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 相册Action<br>
 */
@SuppressWarnings("unchecked")
public class PhotoCommentReplyAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer replyId; 			// 回复ID
	private String commentId;			// 评论ID
	private String replyKeeno;			// 回复人号码
	private String replyContent; 		// 评论内容
	private String replyDate; 			// 评论时间
	private String status;				// 状态[YES||NO]
	private List avatarList;			// 头像List
	private List userList;				// 用户List
	
	public String addPhotoCommentReply() throws Exception {
		keeno = Integer.valueOf(replyKeeno);
		replyDate = DateTime.getDateTime();
		replyId = photoCommentReplyServe.addPhotoCommentReply(Integer.valueOf(commentId), keeno, replyContent, replyDate);
		avatarList = avatarServe.viewAvatar(keeno);
		userList = userServe.viewUser(keeno);
		if (replyId > 0) {
			setStatus("YES");
			return SUCCESS;
		}else {
			setStatus("NO");
			return "Fails";
		}
	}

	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getReplyKeeno() {
		return replyKeeno;
	}
	public void setReplyKeeno(String replyKeeno) {
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
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getAvatarList() {
		return avatarList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public List getUserList() {
		return userList;
	}
}
