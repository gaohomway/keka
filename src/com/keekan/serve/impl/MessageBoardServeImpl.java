package com.keekan.serve.impl;

import java.util.Date;
import java.util.List;

import com.keekan.bean.MessageBoardBean;
import com.keekan.dao.MessageBoardDao;
import com.keekan.serve.MessageBoardServe;

@SuppressWarnings("unchecked")
public class MessageBoardServeImpl implements MessageBoardServe {

	private MessageBoardDao messageBoardDao;
	
	public int addMessage(Integer keeno, Integer friendKeeno, String messageContent, Date messageDate ) throws Exception {
		try {
			MessageBoardBean m = new MessageBoardBean();
			m.setKeeno(keeno);
			m.setFriendKeeno(friendKeeno);
			m.setMessageContent(messageContent);
			m.setMessageDate(messageDate);
			messageBoardDao.addMessage(m);
			return m.getMessageId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加留言时出现异常！");
		}
	}
	
	public List viewLeaveMessage(Integer keeno) throws Exception {
		try {
			List leaveMessageList = messageBoardDao.viewLeaveMessage(keeno);
			return leaveMessageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看留言时出现异常！");
		}
	}
	
	public MessageBoardDao getMessageBoardDao() {
		return messageBoardDao;
	}
	public void setMessageBoardDao(MessageBoardDao messageBoardDao) {
		this.messageBoardDao = messageBoardDao;
	}
}
