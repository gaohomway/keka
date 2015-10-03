package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.FriendGroupBean;
import com.keekan.dao.FriendGroupDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class FriendGroupDaoImpl extends HibernateDaoSupport implements FriendGroupDao{
	
	/**
	 * 添加好友分组
	 * @param friendGroupBean
	 */
	public Integer addFriendGroup(FriendGroupBean friendGroupBean) {
		getHibernateTemplate().save(friendGroupBean);
		return 0;
	}
	
	/**
	 * 查看好友分组
	 * @param keeno
	 */
	public List viewFriendGroup(Integer keeno) {
		List friendGroupList = getHibernateTemplate().find("from FriendGroupBean au where au.keeno = ?", keeno );
		if (friendGroupList != null && friendGroupList.size() >=1) {
			return friendGroupList;
		} else {
			return null;
		}
	}

	/**
	 * 好友分组条数
	 * @param keeno
	 */
	public Integer friendGroupNumber(Integer keeno) {
		List friendGroup = getHibernateTemplate().find("select count(*) from FriendGroupBean au where au.keeno = ?", keeno);
		if (friendGroup != null && friendGroup.size() >=1) {
			return ((Number) friendGroup.get(0)).intValue();
		} else {
			return null;
		}
	}

	/**
	 * 删除好友分组
	 */
	public Integer deleteFriendGroup(Integer keeno, Integer friendGroupId) {
		getHibernateTemplate().delete(getHibernateTemplate().get(FriendGroupBean.class , friendGroupId));
		return friendGroupId;
	}

	/**
	 * 编辑好友分组
	 */
	public Integer editFriendGroup(FriendGroupBean f) {
		getHibernateTemplate().update(f);
		return null;
	}

}
