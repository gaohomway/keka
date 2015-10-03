package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.PhotoReviewBean;
import com.keekan.dao.PhotoReviewDao;
import com.keekan.serve.PhotoReviewServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoReviewServeImpl implements PhotoReviewServe {
	
	private PhotoReviewDao photoReviewDao;

	/**
	 * 添加照片评论
	 */
	public Integer addPhotoReview(Integer photoId, Integer reviewKeeno,
			String reviewContent, String reviewDate) throws Exception {
		try {
			PhotoReviewBean p = new PhotoReviewBean();
			p.setPhotoId(photoId);
			p.setReviewKeeno(reviewKeeno);
			p.setReviewContent(reviewContent);
			p.setReviewDate(reviewDate);
			photoReviewDao.addPhotoReview(p);
			return p.getReviewId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加照片评论时出现异常！");
		}
		
	}
	
	/**
	 * 查看单张照片的评论
	 * @param photoId
	 * @return
	 */
	public List viewReview(Integer photoId) throws Exception {
		try {
			List reviewList = photoReviewDao.viewReview(photoId);
			if (reviewList != null && reviewList.size() >= 1) {
				return reviewList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看照片评论时出现异常！");
		}
	}

	public PhotoReviewDao getPhotoReviewDao() {
		return photoReviewDao;
	}
	public void setPhotoReviewDao(PhotoReviewDao photoReviewDao) {
		this.photoReviewDao = photoReviewDao;
	}
}
