package com.keekan.action;

import java.util.List;

import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 照片评论Action<br>
 */
@SuppressWarnings("unchecked")
public class PhotoReviewAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer reviewId; 			// 评论ID
	private String photoId;				// 照片ID
	private String reviewKeeno;		// 评论人号码
	private String reviewContent; 		// 评论内容
	private String reviewDate; 		// 评论时间
	private String status;				// 状态[YES||NO]
	private List avatarList;			// 头像List
	private List userList;				// 用户List
	
	/**
	 * 添加照片评论
	 */
	public String addPhotoReview() throws Exception {
		
		keeno = Integer.valueOf(reviewKeeno);
		reviewDate = DateTime.getDateTime();
		
		reviewId = photoReviewServe.addPhotoReview(Integer.valueOf(photoId), keeno, reviewContent, reviewDate);
		
		avatarList = avatarServe.viewAvatar(Integer.valueOf(reviewKeeno));
		userList = userServe.viewUser(keeno);
		if (reviewId > 0) {
			status = "YES";
			return SUCCESS;
		}else {
			status = "NO";
			return "Fails";
		}
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getReviewKeeno() {
		return reviewKeeno;
	}

	public void setReviewKeeno(String reviewKeeno) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List getAvatarList() {
		return avatarList;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}
}
