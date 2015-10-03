package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface FriendServe {
	
	/**
	 * 初始化查看好友
	 * @param keeno
	 */
	List initViewFriend(Integer keeno) throws Exception;

	/**
	 * 查上线需通知的好友
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	List onlineNotice(Integer keeno) throws Exception;
	
	/**
	 * 添加好友
	 * @param keeno
	 * @param friendKeeno
	 * @param ownFriendGroupId
	 * @param remarkName
	 * @return
	 * @throws Exception
	 */
	Integer addFriend(Integer keeno, Integer friendKeeno, Integer ownFriendGroupId, String remarkName ) throws Exception;
}
