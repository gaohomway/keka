package com.keekan.dao;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface UserDao {

	/**
	 * 查看用户信息
	 * @param keeno
	 */
	List viewUser(Integer keeno);
	
	/**
	 * 查看用户名片
	 * @param keeno
	 * @return
	 */
	List viewUserByCarte(Integer[] keeno);
	
	/**
	 * 搜索好友
	 * @return
	 */
	List searchFriend();
}
