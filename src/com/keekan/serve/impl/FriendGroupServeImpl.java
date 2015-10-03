package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.FriendGroupBean;
import com.keekan.dao.FriendGroupDao;
import com.keekan.serve.FriendGroupServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class FriendGroupServeImpl implements FriendGroupServe {
	
	private FriendGroupDao friendGroupDao;
	
	/**
	 * 添加好友分组
	 * @param keeno
	 * @param friendGroupName
	 */
	public Integer addFriendGroup(Integer keeno, String friendGroupName, Integer groupSorting) throws Exception {
		try {
			FriendGroupBean f = new FriendGroupBean();
			f.setKeeno(keeno);
			f.setFriendGroupName(friendGroupName);
			f.setGroupSorting(groupSorting);
			friendGroupDao.addFriendGroup(f);
			return f.getFriendGroupId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加相册分类时出现异常");
		}
	}
	
	/**
	 * 查看好友分组
	 * @param keeno
	 */
	public List viewAllFriendGroup(Integer keeno) throws Exception {
		try {
			List friendGroupList = friendGroupDao.viewFriendGroup(keeno);
			if (friendGroupList != null) {
				return friendGroupList;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看好友分组时出现异常");
		}
	}

	/**
	 * 好友分组条数
	 * @param keeno
	 * @return
	 */
	public Integer friendGroupNumber(Integer keeno) throws Exception {
		try {
			Integer friendGroupNumber = friendGroupDao.friendGroupNumber(keeno);
			return friendGroupNumber;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("好友分组条数时出现异常");
		}
	}
	
	public void setFriendGroupDao(FriendGroupDao friendGroupDao) {
		this.friendGroupDao = friendGroupDao;
	}

	/**
	 * 删除好友分组
	 */
	public Integer deleteFriendGroup(Integer keeno, String friendGroupId) throws Exception {
		try {
			Integer friendGroup = friendGroupDao.deleteFriendGroup(keeno, Integer.valueOf(friendGroupId));
			return friendGroup;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("删除好友分组时出现异常");
		}
	}

	/**
	 * 编辑好友分组
	 */
	public Integer editFriendGroup(Integer keeno, Integer friendGroupId, String friendGroupName ) throws Exception {
		try {
			FriendGroupBean f = new FriendGroupBean();
			f.setKeeno(keeno);
			f.setFriendGroupId(friendGroupId);
			f.setFriendGroupName(friendGroupName);
			friendGroupDao.editFriendGroup(f);
			return f.getFriendGroupId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("编辑好友分组时出现异常");
		}
	}

}
