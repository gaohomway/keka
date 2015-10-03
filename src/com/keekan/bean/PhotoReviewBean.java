package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册评论表持久化Bean类 <br>
 */
public class PhotoReviewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer reviewId; 			// 评论ID
	private Integer photoId;			// 照片ID
	private Integer reviewKeeno;		//评论人号码
	private String reviewContent; 		// 评论内容
	private String reviewDate; 			// 评论时间
	
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	public Integer getReviewKeeno() {
		return reviewKeeno;
	}
	public void setReviewKeeno(Integer reviewKeeno) {
		this.reviewKeeno = reviewKeeno;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
}
