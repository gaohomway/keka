package com.keekan.dao;

import java.util.List;

import com.keekan.bean.PhotoReviewBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface PhotoReviewDao {

	/**
	 * 添加照片评论
	 * @param photoReviewBean
	 * @return
	 */
	Integer addPhotoReview(PhotoReviewBean photoReviewBean);
	
	/**
	 * 查看单张照片评论
	 * @param photoId
	 * @return
	 */
	List viewReview(Integer photoId);
}
