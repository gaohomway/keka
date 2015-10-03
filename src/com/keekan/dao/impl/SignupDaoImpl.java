package com.keekan.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.UserBean;
import com.keekan.dao.SignupDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 * Copyright (C), 2012-, keekan.com <br>
 * This program is protected by copyright laws. <br>
 * Program Name: KEEKAN<br>
 * Class Name: 注册Dao接口实现 <br>
 */
public class SignupDaoImpl extends HibernateDaoSupport implements SignupDao {

	/**
	 * 保存用户信息
	 */
	public Integer saveUser(UserBean userBean) {
		getHibernateTemplate().save(userBean);
		return null;
	}

	/**
	 * 保存号码
	 */
	public Integer saveKeeno(UserBean u) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("update UserBean au set au.keeno ="+ u.getKeeno() +" where au.userId="+ u.getUserId());
		query.executeUpdate();
		return 0;
	}

}
