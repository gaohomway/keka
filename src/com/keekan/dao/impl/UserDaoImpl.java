package com.keekan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.UserBean;
import com.keekan.dao.UserDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 查看用户信息
	 * @param keeNumber
	 */
	public List viewUser(Integer keeno) {
		List userList = getHibernateTemplate().find("from UserBean au where au.keeno = ?", keeno);
		if (userList != null && userList.size() >= 1) {
			return userList;
		} else {
			return null;
		}
	}

	/**
	 * 查看用户名片
	 * @param keeNumber
	 * @return
	 */
	public List viewUserByCarte(Integer[] keeno) {

		List<UserBean> userList = new ArrayList<UserBean>();
		List<UserBean> u = new ArrayList<UserBean>();
		for (int i = 0; i < keeno.length; i++) {
			u = getHibernateTemplate().find("from UserBean au where au.keeno in(?)", keeno[i]);
			userList.addAll(u);
		}

		if (userList != null) {
			return userList;
		} else {
			return null;
		}
	}

	/**
	 * 搜索好友
	 */
	public List searchFriend() {
		List userList = getHibernateTemplate().find("from UserBean");
		if (userList != null && userList.size() >= 1) {
			return userList;
		} else {
			return null;
		}
	}
}
