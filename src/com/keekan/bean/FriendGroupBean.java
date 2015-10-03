package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友分组表持久化Bean类 <br>
 */
public class FriendGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer  friendGroupId; 	// 表示ID
	private Integer keeno; 				// KEE号
	private String friendGroupName; 	// 相册分组的名字
	private Integer groupSorting;		//分组排序
	
	public Integer getFriendGroupId() {
		return friendGroupId;
	}
	public void setFriendGroupId(Integer friendGroupId) {
		this.friendGroupId = friendGroupId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getFriendGroupName() {
		return friendGroupName;
	}
	public void setFriendGroupName(String friendGroupName) {
		this.friendGroupName = friendGroupName;
	}
	public Integer getGroupSorting() {
		return groupSorting;
	}
	public void setGroupSorting(Integer groupSorting) {
		this.groupSorting = groupSorting;
	}
}
