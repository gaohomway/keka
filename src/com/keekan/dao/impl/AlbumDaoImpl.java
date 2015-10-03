package com.keekan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AlbumBean;
import com.keekan.dao.AlbumDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao {

	/**
	 * 添加相册
	 * @param albumBean 相册Bean
	 */
	public Integer addAlbum(AlbumBean albumBean) {
		getHibernateTemplate().save(albumBean);
		return 0;
	}

	/**
	 * 查看全部相册
	 * @param albumBean 相册Bean
	 * @return albumName 相册名字
	 */
	public List viewAllAlbum(Integer[] albumGroupIds) {
		List<AlbumBean> albumList = new ArrayList<AlbumBean>(albumGroupIds.length);
		List<AlbumBean> albumName = new ArrayList<AlbumBean>();
		for (int i = 0; i < albumGroupIds.length; i++) {
			albumName = getHibernateTemplate().find("from AlbumBean au where au.ownAlbumGroupId in(?)", albumGroupIds[i]);
			albumList.addAll(albumName);
		}

		if (albumList != null && albumList.size() >= 1) {
			return albumList;
		} else {
			return null;
		}
	}

	/**
	 * 根据KEE号码查询所有相册
	 * 
	 * @param keeno
	 * @return
	 */
	public List viewAllAlbumByKeeno(Integer keeno) {
		List albumNameList = getHibernateTemplate().find("select au.albumName from AlbumBean au where au.keeno = ?", keeno);
		if (albumNameList != null && albumNameList.size() >= 1) {
			return albumNameList;
		} else {
			return null;
		}
	}

	/**
	 * 获取相册ID
	 * @param keeno
	 * @return
	 */
	public List getAlbumId(Integer keeno, String albumName) {
		List albumList =  getHibernateTemplate().find("select au.albumId from AlbumBean au where au.keeno = "+keeno+" and au.albumName = ?", albumName);
		if (albumList != null && albumList.size() >= 1) {
			return albumList;
		} else {
			return null;
		}
	}

	/**
	 * 根据相册ID查询相册
	 */
	public List viewAlbumByAlbumId(Integer albumId) {
		List albumList = getHibernateTemplate().find("from AlbumBean au where au.albumId = ?", albumId);
		if (albumList != null && albumList.size() >= 1) {
			return albumList;
		} else {
			return null;
		}
	}
}
