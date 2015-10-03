package com.keekan.dao;

import java.util.List;

import com.keekan.bean.MessageBoardBean;

@SuppressWarnings("unchecked")
public interface MessageBoardDao {
	
	/**
	 * 添加留言
	 * @param messageBoardBean 留言Bean
	 */
	 void addMessage(MessageBoardBean messageBoardBean);
	 
	 /**
	  * 查看留言
	  * @param keeno
	  * @return
	  */
	 List viewLeaveMessage(Integer keeno);
}
