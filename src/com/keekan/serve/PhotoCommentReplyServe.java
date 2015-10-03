package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片评论回复的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface PhotoCommentReplyServe {

	/**
	 * 添加照片评论回复
	 * @param commentId
	 * @param replyKeeno
	 * @param replyContent
	 * @param replyDate
	 * @return
	 * @throws Exception
	 */
	Integer addPhotoCommentReply(Integer commentId, Integer replyKeeno, String replyContent, String replyDate) throws Exception;
	
	/**
	 * 查看单张照片的评论回复
	 * @param photoId
	 * @return
	 */
	List viewCommentReply(Integer[] commentId) throws Exception;
}
