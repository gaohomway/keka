package com.keekan.dao;

import java.util.List;

import com.keekan.bean.FriendGroupBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface FriendGroupDao {
	
	/**
	 * 添加好友分组
	 * @param friendGroupBean
	 * @return
	 */
	Integer addFriendGroup(FriendGroupBean friendGroupBean);
	
	/**
	 * 删除好友分组
	 * @param keeno
	 * @param friendGroupId
	 * @return
	 */
	Integer deleteFriendGroup(Integer keeno, Integer friendGroupId);
	
	/**
	 * 编辑好友分组
	 * @param friendGroupBean
	 * @return
	 */
	Integer editFriendGroup(FriendGroupBean friendGroupBean);
	
	/**
	 * 查看分组
	 * @param keeno
	 */
	List viewFriendGroup(Integer keeno);

	
	/**
	 * 好友分组条数
	 * @param keeno
	 * @return
	 */
	Integer friendGroupNumber(Integer keeno);
	
	
}
