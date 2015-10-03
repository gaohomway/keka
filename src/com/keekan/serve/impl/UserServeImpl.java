package com.keekan.serve.impl;

import java.util.List;

import com.keekan.dao.UserDao;
import com.keekan.serve.UserServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 * Copyright (C), 2012-, keekan.com <br>
 * This program is protected by copyright laws. <br>
 * Program Name: KEEKAN<br>
 * Class Name: 相册的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class UserServeImpl implements UserServe {

	private UserDao userDao;
	
	/**
     * 查看用户信息
     * @param keeno
     * @return 
     */
	
	public List viewUser(Integer keeno) throws Exception {
		try {
			List userList = userDao.viewUser(keeno);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看用户信息时出现异常！");
		}
	}
	
	/**
	 * 查看用户名片
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	public List viewUserByCarte(Integer[] keeno) throws Exception {
		try {
			List userList = userDao.viewUserByCarte(keeno);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看用户信息时出现异常！");
		}
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 搜索好友
	 */
	public List searchFriend() throws Exception {
		try {
			List userList = userDao.searchFriend();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("搜索好友时出现异常！");
		}
	}
}
