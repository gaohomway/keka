package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.FriendBean;
import com.keekan.dao.FriendDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class FriendDaoImpl extends HibernateDaoSupport implements FriendDao{

	/**
	 * 初始化查看好友
	 * @param keeno
	 */
	public List initViewFriend(Integer keeno) {
		List friendList = getHibernateTemplate().find("from FriendBean au where au.keeno = ?", keeno );
		if (friendList != null && friendList.size() >=1) {
			return friendList;
		} else {
			return null;
		}
	}

	/**
	 * 查上线需通知的好友
	 */
	public List onlineNotice(Integer keeno) {
		List friendList = getHibernateTemplate().find("from FriendBean au where au.friendKeeno = ?", keeno );
		if (friendList != null && friendList.size() >=1) {
			return friendList;
		} else {
			return null;
		}
	}

	/**
	 * 添加好友
	 */
	public Integer addFriend(FriendBean friendBean) {
		getHibernateTemplate().save(friendBean);
		return null;
	}

}
