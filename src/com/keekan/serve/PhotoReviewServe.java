package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface PhotoReviewServe {

	/**
	 * 添加照片评论
	 * @param photoId
	 * @param reviewKeeno
	 * @param reviewContent
	 * @param reviewDate
	 * @return
	 * @throws Exception
	 */
	Integer addPhotoReview(Integer photoId, Integer reviewKeeno, String reviewContent, String reviewDate) throws Exception;
	
	
	/**
	 * 查看单张照片的评论
	 * @param photoId
	 * @return
	 */
	List viewReview(Integer photoId) throws Exception;
}
