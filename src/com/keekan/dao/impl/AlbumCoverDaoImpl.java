package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AlbumCoverBase;
import com.keekan.dao.AlbumCoverDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册封面的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AlbumCoverDaoImpl extends HibernateDaoSupport implements AlbumCoverDao {

	/**
	 * 添加相册封面
	 */
	public Integer addAlbumCover(AlbumCoverBase albumCoverBase) {
		getHibernateTemplate().save(albumCoverBase);
		return null;
	}

	/**
	 * 查看相册封面
	 */
	public List viewAlbumCover(Integer[] albumIds) {
		String parm = "";
		for (int i = 0; i < albumIds.length; i++) {
			parm += String.valueOf(albumIds[i])+",";
		}
		String parms = parm.substring(0, parm.length()-1);
		List albumCoverList = getHibernateTemplate().find("from AlbumCoverBase au where au.ownAlbumId in("+parms+")");
		if (albumCoverList != null && albumCoverList.size() >= 1) {
			return albumCoverList;
		} else {
			return null;
		}
	}

	/**
	 * 查看相册封面
	 */
	public List viewAlbumCover(Integer albumIds) {
		List albumCoverList = getHibernateTemplate().find("from AlbumCoverBase au where au.ownAlbumId in(?)", albumIds);
		if (albumCoverList != null && albumCoverList.size() >= 1) {
			return albumCoverList;
		} else {
			return null;
		}
	}

	/**
	 * 编辑相册封面
	 */
	public Integer editAlbumCover(AlbumCoverBase albumCoverBase) {
		getHibernateTemplate().update(albumCoverBase);
		return null;
	}

	/**
	 * 随机相册封面
	 */
	public List randomAlbumCover(Integer ownAlbumId, String uploadDate) {
		List photoList = getHibernateTemplate().find("from PhotoBean au where  au.ownAlbumId ="+ownAlbumId+" and au.uploadDate ='"+uploadDate+"'");
		if (photoList != null &&photoList.size() >= 1) {
			return photoList;
		} else {
			return null;
		}
	}

}
