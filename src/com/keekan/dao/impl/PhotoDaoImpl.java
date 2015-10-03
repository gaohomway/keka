package com.keekan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.keekan.bean.PhotoBean;
import com.keekan.dao.PhotoDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao {

	/**
	 * 照片总数[用于分页]
	 */
	public Integer photoSumCount(Integer ownAlbumId) {
		List sumPhotoList = getHibernateTemplate().find("select count(ownAlbumId) from PhotoBean au where au.ownAlbumId = ?", ownAlbumId);
		Integer sumPhotoCount = Integer.valueOf(String.valueOf(sumPhotoList.get(0)));
		if (sumPhotoCount != null) {
			return sumPhotoCount;
		} else {
			return null;
		}
	}
	
	/**
	 * 查看照片缩略图[分页]
	 */
	public List viewPhotoThumbnail(Integer albumId, Integer startPhoto, Integer perPagePhoto) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List photoList = session.createQuery("from PhotoBean au where au.ownAlbumId = ?").setInteger(0, albumId).setFirstResult(startPhoto).setMaxResults(perPagePhoto).list();
		tx.commit();
		session.close();
		if (photoList != null && photoList.size() >= 1) {
			return photoList;
		} else {
			return null;
		}
	}

	/**
	 * 查看照片
	 */
	public List viewPhoto(Integer photoId) {
		List photoList = getHibernateTemplate().find("from PhotoBean au where au.photoId in(?)", photoId);
		if (photoList != null && photoList.size() >= 1) {
			return photoList;
		} else {
			return null;
		}
	}

	/**
	 * 上传照片
	 */
	public void photoUpload(PhotoBean photoBean) {
		getHibernateTemplate().save(photoBean);
		photoBean.getPhotoId();
	}

	/**
	 * 照片张数
	 */
	public Integer[] photoNumber(Integer[] albumIds) {
		Integer[] photoNumber = new Integer[albumIds.length];
		for (int i = 0; i < albumIds.length; i++) {
			List<Integer> photoNumberList = getHibernateTemplate().find("select count(ownAlbumId) from PhotoBean au where au.ownAlbumId in(?)", albumIds[i]);
			photoNumber[i] =  Integer.valueOf(String.valueOf(photoNumberList.get(0)));
		}
		if (photoNumber != null && photoNumber.length >= 1) {
			return photoNumber;
		} else {
			return null;
		}
	}

	/**
	 * 获取单次上传照片张数
	 */
	public Integer uploadPhotoNumber(Integer ownAlbumId, String uploadDate) {
		List photoNumberList = getHibernateTemplate().find("select count(ownAlbumId) from PhotoBean au where au.ownAlbumId ="+ownAlbumId+" and au.uploadDate ='"+uploadDate+"'");
		Integer photoNumber = Integer.valueOf(String.valueOf(photoNumberList.get(0)));
		if (photoNumber != null) {
			return photoNumber;
		} else {
			return null;
		}
	}

	/**
	 * 保存照片信息
	 */
	public Integer savePhotoInfo(PhotoBean p) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "update PhotoBean au set au.rawPhotoName= ? , au.photoDescription= ?  where au.ownAlbumId= ? and au.uploadDate= ? ";
		Query query = session.createQuery(hql);
		query.setString(0, p.getRawPhotoName());
		query.setString(1, p.getPhotoDescription());
		query.setInteger(2, p.getOwnAlbumId());
		query.setString(3, p.getUploadDate());
		query.executeUpdate();
		tx.commit();
		session.close();
		return 0;
	}

	/**
	 * 照片张数
	 */
	public Integer photoNumber(Integer albumId) {
		List photoNumberList = getHibernateTemplate().find("select count(ownAlbumId) from PhotoBean au where au.ownAlbumId = ?", albumId);
		Integer photoNumber =  Integer.valueOf(String.valueOf(photoNumberList.get(0)));
		if (photoNumber != null) {
			return photoNumber;
		} else {
			return null;
		}
	}
}
