package com.keekan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.PhotoCommentReplyBean;
import com.keekan.dao.PhotoCommentReplyDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论回复的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoCommentReplyDaoImpl extends HibernateDaoSupport implements PhotoCommentReplyDao{

	/**
	 * 添加照片评论回复
	 */
	public Integer addPhotoCommentReply(PhotoCommentReplyBean photoCommentReplyBean) {
		getHibernateTemplate().save(photoCommentReplyBean);
		return null;
	}

	/**
	 * 查看照片评论的回复
	 */
	public List viewCommentReply(Integer[] commentId) {
		List<PhotoCommentReplyBean> replyList = new ArrayList<PhotoCommentReplyBean>(commentId.length);
		List<PhotoCommentReplyBean> rList = new ArrayList<PhotoCommentReplyBean>();
		for (int i = 0; i < commentId.length; i++) {
			rList = getHibernateTemplate().find("from PhotoCommentReplyBean au where au.commentId in(?)", commentId[i]);
			replyList.addAll(rList);
		}
		if (replyList != null && replyList.size() >= 1) {
			return replyList;
		} else {
			return null;
		}
	}

}
