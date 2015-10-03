package com.keekan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AvatarBean;
import com.keekan.dao.AvatarDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 * Copyright (C), 2012-, keekan.com <br>
 * This program is protected by copyright laws. <br>
 * Program Name: KEEKAN<br>
 * Class Name: 头像的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AvatarDaoImpl extends HibernateDaoSupport implements AvatarDao {

	/**
	 * 初始化添加头像
	 * @param avatarBean 头像Bean
	 */
	public Integer initAddAvatar(AvatarBean avatarBean) {
		 getHibernateTemplate().save(avatarBean);
		return 0;
	}

	/**
	 * 查看头像(单张正在使用)
	 */
	public List viewAvatar(Integer keeno) {
		List avatarList = getHibernateTemplate().find("from AvatarBean au where au.keeno = ? and au.inuse = 'yes'", keeno);
		if (avatarList != null && avatarList.size() >= 1) {
			return avatarList;
		}else {
			return null;
		}
	}

	/**
	 * 根据号码查看头像
	 * @param keeno
	 * @return
	 */
	public List viewAllAvatar(Integer[] keeno) {
		List<AvatarBean> avatarList = new ArrayList<AvatarBean>(keeno.length);
		List<AvatarBean> avatar = new ArrayList<AvatarBean>();
		for (int i = 0; i < keeno.length; i++) {
			avatar = getHibernateTemplate().find("from AvatarBean au where au.updateDate = (select MAX(au.updateDate) from AvatarBean au where au.keeno = ?)", keeno[i]);
			avatarList.addAll(avatar);
		}
		if (avatarList != null && avatarList.size() >= 1) {
			return avatarList;
		}else {
			return null;
		}
	}

	/**
	 * 更新头像
	 */
	public List renewAvatar(AvatarBean avatarBean, Integer keeno) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("update AvatarBean au set au.inuse = '' where au.keeno= ? and au.inuse = 'yes'");
		query.setInteger(0, keeno);
		query.executeUpdate();
		getHibernateTemplate().save(avatarBean);
		return null;
	}

	/**
	 * 查看头像(正在使用的和历史头像)
	 */
	public List viewAllAvatar(Integer keeno) {
		List avatarList = getHibernateTemplate().find("from AvatarBean au where au.keeno= ?", keeno);
		if (avatarList != null && avatarList.size() >= 1) {
			return avatarList;
		}else {
			return null;
		}
	}
}
