package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.PhotoCommentReplyBean;
import com.keekan.dao.PhotoCommentReplyDao;
import com.keekan.serve.PhotoCommentReplyServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论回复的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoCommentReplyServeImpl implements PhotoCommentReplyServe {

	private PhotoCommentReplyDao photoCommentReplyDao;
	
	/**
	 * 添加照片评论回复
	 */
	public Integer addPhotoCommentReply(Integer commentId, Integer replyKeeno, String replyContent, String replyDate) throws Exception {
		try {
			PhotoCommentReplyBean p = new PhotoCommentReplyBean();
			p.setCommentId(commentId);
			p.setReplyKeeno(replyKeeno);
			p.setReplyContent(replyContent);
			p.setReplyDate(replyDate);
			photoCommentReplyDao.addPhotoCommentReply(p);
			return p.getReplyId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加照片评论回复时出现异常！");
		}
	}
	
	/**
	 * 查看单张照片的评论回复
	 */
	public List viewCommentReply(Integer[] commentId) throws Exception {
		try {
			List replyList = photoCommentReplyDao.viewCommentReply(commentId);
			return replyList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看照片评论回复时出现异常！");
		}
		
	}
	public PhotoCommentReplyDao getPhotoCommentReplyDao() {
		return photoCommentReplyDao;
	}
	public void setPhotoCommentReplyDao(PhotoCommentReplyDao photoCommentReplyDao) {
		this.photoCommentReplyDao = photoCommentReplyDao;
	}
}
