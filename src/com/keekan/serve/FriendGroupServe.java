package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface FriendGroupServe {
	
	/**
	 * 添加好友分组
	 * @param keeno
	 * @param friendGroupName
	 */
	Integer addFriendGroup(Integer keeno, String friendGroupName,Integer groupSorting) throws Exception;
	
	/**
	 * 删除好友分组
	 * @param keeno
	 * @param friendGroupId
	 * @return
	 * @throws Exception
	 */
	Integer deleteFriendGroup(Integer keeno, String friendGroupId) throws Exception;
	
	/**
	 * 编辑好友分组
	 * @param keeno
	 * @param friendGroupName
	 * @param groupSorting
	 * @return
	 * @throws Exception
	 */
	Integer editFriendGroup(Integer keeno, Integer friendGroupId, String friendGroupName ) throws Exception;
	
	/**
	 * 查看全部好友分组
	 * @param keeno
	 */
	List viewAllFriendGroup(Integer keeno) throws Exception;
	
	/**
	 * 好友分组条数
	 * @param keeno
	 * @return
	 */
	Integer friendGroupNumber(Integer keeno) throws Exception;
	
	
}
