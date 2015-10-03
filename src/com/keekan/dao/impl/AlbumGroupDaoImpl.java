package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AlbumGroupBean;
import com.keekan.dao.AlbumGroupDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册分类的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AlbumGroupDaoImpl extends HibernateDaoSupport implements AlbumGroupDao {

	/**
	 * 添加相册分类
	 */
	public Integer addAlbumGroup(AlbumGroupBean a) {
		getHibernateTemplate().save(a);
		return 0;
	}
	
	/**
	 * 删除相册分类
	 */
	public Integer deleteAlbumGroup(AlbumGroupBean a) {
		getHibernateTemplate().delete(getHibernateTemplate().get(AlbumGroupBean.class , a.getAlbumGroupId()));
		return a.getAlbumGroupId();
	}
	
	/**
	 * 编辑相册分类
	 */
	public Integer editAlbumGroup(AlbumGroupBean a) {
		getHibernateTemplate().update(a);
		return null;
	}
	
	/**
	 * 查看全部分类
	 */
	public List viewAllAlbumGroup(Integer keeno) {
		List albumGroupList = getHibernateTemplate().find("from AlbumGroupBean au where au.keeno = ?", keeno );
		if (albumGroupList != null && albumGroupList.size() >=1) {
			return albumGroupList;
		} else {
			return null;
		}
	}
}
