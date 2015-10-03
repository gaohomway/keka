package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 好友表持久化Bean类 <br>
 */
public class FriendBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer  friendId; 				// 表示ID
	private Integer keeno;	 				// KEE号
	private Integer friendKeeno; 			// 好友KEE号
	private Integer ownFriendGroupId; 		// 所属分组ID
	private String remarkName;				// 备注姓名
	
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public Integer getFriendKeeno() {
		return friendKeeno;
	}
	public void setFriendKeeno(Integer friendKeeno) {
		this.friendKeeno = friendKeeno;
	}
	public Integer getOwnFriendGroupId() {
		return ownFriendGroupId;
	}
	public void setOwnFriendGroupId(Integer ownFriendGroupId) {
		this.ownFriendGroupId = ownFriendGroupId;
	}
	public String getRemarkName() {
		return remarkName;
	}
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
}
