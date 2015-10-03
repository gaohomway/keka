package com.keekan.dao;

import com.keekan.bean.UserBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 注册的Dao接口 <br>
 */
public interface SignupDao {

	/**
	 * 保存用户信息
	 * @param userInforBean
	 */
	Integer saveUser(UserBean userBean);
	
	/**
	 * 保存KEE号码
	 * @param userId
	 * @param keeno
	 * @return
	 */
	Integer saveKeeno(UserBean userBean);
}
