package com.keekan.dao;

import java.util.List;

import com.keekan.bean.PhotoCommentReplyBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论回复的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface PhotoCommentReplyDao {

	/**
	 * 添加照片评论回复
	 * @param photoCommentReplyBean
	 * @return
	 */
	Integer addPhotoCommentReply(PhotoCommentReplyBean photoCommentReplyBean);
	
	/**
	 * 查看单张照片评论回复
	 * @param commentId
	 * @return
	 */
	List viewCommentReply(Integer[] commentId);
}
