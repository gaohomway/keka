package com.keekan.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.keekan.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("unchecked")
public class MessageBoardAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer id; 					// 序列id
	private Integer friendKeeNumber; 		// 好友的号码
	private String messageContent; 			// 留言内容
	private Date messageDate; 				// 留言时间
	private Integer messageId; 				// 第几位
	private String editorValue;				//留言信息
	private List leaveMessageList;			//留言信息List
	
	public String addMessage() throws Exception {
		Map session = ActionContext.getContext().getSession();
		keeno = (Integer) session.get("keeno");
		messageBoardServe.addMessage(keeno, friendKeeNumber, editorValue, messageDate);
		return "addMessageSuccess";
	}
	
	public String viewLeaveMessage()throws Exception{
		Map session = ActionContext.getContext().getSession();
		keeno = (Integer) session.get("keeno");
		leaveMessageList = messageBoardServe.viewLeaveMessage(keeno);
		return "viewLeaveMessageSuccess";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}

	public String getEditorValue() {
		return editorValue;
	}

	public void setFriendKeeNumber(Integer friendKeeNumber) {
		this.friendKeeNumber = friendKeeNumber;
	}

	public Integer getFriendKeeNumber() {
		return friendKeeNumber;
	}

	public void setLeaveMessageList(List leaveMessageList) {
		this.leaveMessageList = leaveMessageList;
	}

	public List getLeaveMessageList() {
		return leaveMessageList;
	}

}
