package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.FriendBean;
import com.keekan.dao.FriendDao;
import com.keekan.serve.FriendServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class FriendServeImpl implements FriendServe {
	
	private FriendDao friendDao;

	/**
	 * 初始化查看好友
	 * @param keeno
	 */
	public List initViewFriend(Integer keeno) throws Exception {
		try {
			List friendList = friendDao.initViewFriend(keeno);
			if (friendList != null) {
				return friendList;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看好友时出现异常");
		}
	}
	
	/**
	 * 查上线需通知的好友
	 */
	public List onlineNotice(Integer keeno) throws Exception {
		try {
			List friendList = friendDao.onlineNotice(keeno);
			if (friendList != null) {
				return friendList;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查上线需通知的好友时出现异常");
		}
	}

	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	/**
	 * 添加好友
	 */
	public Integer addFriend(Integer keeno, Integer friendKeeno, Integer ownFriendGroupId, String remarkName) throws Exception {
		try {
			FriendBean f = new FriendBean();
			f.setKeeno(keeno);
			f.setFriendKeeno(friendKeeno);
			f.setOwnFriendGroupId(ownFriendGroupId);
			f.setRemarkName(remarkName);
			friendDao.addFriend(f);
			return f.getFriendId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加好友时出现异常");
		}
	}
}
