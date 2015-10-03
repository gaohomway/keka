package com.keekan.action;

import com.keekan.tool.BaseTools;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 好友分组Action<br>
 */
public class FriendGroupAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String friendGroupName;
	private Integer friendGroupNumber;
	private String friendGroupId;
	
	//添加相册分组方法
	public String addFriendGroup() throws Exception {
		
		friendGroupNumber = friendGroupServe.friendGroupNumber(keeno);
		friendGroupServe.addFriendGroup(keeno, friendGroupName, friendGroupNumber + 1);
		
		return SUCCESS;
	}
	
	//删除相册分组方法
	public String deleteFriendGroup() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		friendGroupServe.deleteFriendGroup(keeno, friendGroupId);
		
		return SUCCESS;
	}
	//编辑相册分组方法
	public String editFriendGroup() throws Exception {
		
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		friendGroupServe.editFriendGroup(keeno, Integer.valueOf(friendGroupId), friendGroupName);
		
		return SUCCESS;
	}
	//查看相册分组方法
	public String viewFriendGroup() throws Exception {
		
		return null;
	}

	public String getFriendGroupName() {
		return friendGroupName;
	}

	public void setFriendGroupName(String friendGroupName) {
		this.friendGroupName = friendGroupName;
	}

	public Integer getFriendGroupNumber() {
		return friendGroupNumber;
	}

	public void setFriendGroupNumber(Integer friendGroupNumber) {
		this.friendGroupNumber = friendGroupNumber;
	}

	public String getFriendGroupId() {
		return friendGroupId;
	}

	public void setFriendGroupId(String friendGroupId) {
		this.friendGroupId = friendGroupId;
	}

}
