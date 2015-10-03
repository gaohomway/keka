package com.keekan.action;

import com.keekan.pushlet.ChatPush;

public class ChatAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String keeno;
	private String friendKeeno;
	private String sendMessage;
	
	public String sendChat() throws Exception {
		
		
		ChatPush chatPush = new ChatPush();
		chatPush.sendChat(keeno, friendKeeno, sendMessage);
		
		return SUCCESS;
	}

	
	public String getFriendKeeno() {
		return friendKeeno;
	}
	public void setFriendKeeno(String friendKeeno) {
		this.friendKeeno = friendKeeno;
	}
	public String getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
}
