package com.keekan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AdoreBean;
import com.keekan.dao.AdoreDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AdoreDaoImpl extends HibernateDaoSupport implements AdoreDao {

	/**
	 * 添加倾心
	 */
	public Integer addAdore(AdoreBean adoreBean) {
		getHibernateTemplate().save(adoreBean);
		return null;
	}
	
	/**
	 * 更新倾心
	 * @return
	 */
	public Integer renewAdore(AdoreBean a){

		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "update AdorePhotoBean au set au.ownAdoreId= ? where au.keeno= ? and au.createDate= ? ";
		Query query = session.createQuery(hql);
		query.setInteger(0, a.getAdoreId());
		query.setInteger(1, a.getKeeno());
		query.setString(2, a.getCreateDate());
		query.executeUpdate();
		tx.commit();
		session.close();
		return 0;
	
	}

	/**
	 * 查询倾心内容根据ID
	 */
	public List viewAdore(Integer keeno) {
		List adoreList = getHibernateTemplate().find("from AdoreBean au where au.keeno = ?", keeno);
		if (adoreList != null && adoreList.size() >= 1) {
			return adoreList;
		} else {
			return null;
		}
	}

	/**
	 * 查询倾心内容
	 */
	public List viewAdoreById(Integer adoreId) {
		List adoreList = getHibernateTemplate().find("from AdoreBean au where au.adoreId = ?", adoreId);
		if (adoreList != null && adoreList.size() >= 1) {
			return adoreList;
		} else {
			return null;
		}
	}

}
