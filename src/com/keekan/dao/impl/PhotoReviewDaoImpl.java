package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.PhotoReviewBean;
import com.keekan.dao.PhotoReviewDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoReviewDaoImpl extends HibernateDaoSupport implements PhotoReviewDao{

	/**
	 * 添加照片评论
	 * @param photoReviewBean
	 * @return
	 */
	public Integer addPhotoReview(PhotoReviewBean photoReviewBean) {
		getHibernateTemplate().save(photoReviewBean);
		return null;
	}

	/**
	 * 查看单张照片评论
	 * @param photoId
	 * @return
	 */
	public List viewReview(Integer photoId) {
		List reviewList = getHibernateTemplate().find("from PhotoReviewBean au where au.photoId in(?)", photoId);
		if (reviewList != null && reviewList.size() >= 1) {
			return reviewList;
		} else {
			return null;
		}
	}

}
