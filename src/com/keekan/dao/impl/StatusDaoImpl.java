package com.keekan.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.StatusBean;
import com.keekan.dao.StatusDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户状态的Dao接口实现 <br>
 */
public class StatusDaoImpl extends HibernateDaoSupport implements StatusDao{

	/**
	 * 初始化添加状态
	 */
	public Integer initAddStatus(StatusBean statusBean) {
		getHibernateTemplate().save(statusBean);
		return 0;
	}

	/**
	 * 登录后更新状态
	 */
	public Integer updateStatus(StatusBean s) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("update StatusBean au set au.status='"+ s.getStatus() +"', au.statusDate='"+ s.getStatusDate() +"' where au.keeno="+ s.getKeeno() );
		query.executeUpdate();
		return 0;
	}

}
