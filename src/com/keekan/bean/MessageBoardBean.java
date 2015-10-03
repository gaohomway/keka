package com.keekan.bean;

import java.io.Serializable;
import java.util.Date;

public class MessageBoardBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer messageId;			//序列id
	private Integer keeno;				//kee号码
	private Integer friendKeeno;	//好友的号码
	private String messageContent;		//留言内容
	private Date messageDate;			//留言时间
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public Integer getFriendKeeno() {
		return friendKeeno;
	}
	public void setFriendKeeno(Integer friendKeeno) {
		this.friendKeeno = friendKeeno;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
}
