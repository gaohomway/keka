package com.keekan.dao;

import java.util.List;

import com.keekan.bean.FriendBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface FriendDao {
	
	/**
	 * 初始化查看好友
	 * @param keeno
	 */
	List initViewFriend(Integer keeno);

	/**
	 * 查上线需通知的好友
	 * @param keeno
	 * @return
	 */
	List onlineNotice(Integer keeno);
	
	/**
	 * 添加好友
	 * @param friendBean
	 * @return
	 */
	Integer addFriend(FriendBean friendBean);
}
