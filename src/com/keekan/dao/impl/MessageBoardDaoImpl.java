package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.MessageBoardBean;
import com.keekan.dao.MessageBoardDao;

@SuppressWarnings("unchecked")
public class MessageBoardDaoImpl extends HibernateDaoSupport implements MessageBoardDao{

	/**
	 * 添加留言
	 */
	public void addMessage(MessageBoardBean messageBoardBean) {
		getHibernateTemplate().save(messageBoardBean);
	}

	/**
	  * 查看留言
	  * @param keeno
	  * @return
	  */
	public List viewLeaveMessage(Integer keeno) {
		List<MessageBoardBean> leaveMessageList = getHibernateTemplate().find("from MessageBoardBean au where au.keeno = ?", keeno);
		if (leaveMessageList != null && leaveMessageList.size() >= 1) {
			return leaveMessageList;
		}else {
			return null;
		}
	}
}
