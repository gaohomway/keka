package com.keekan.action;

import java.util.List;

import com.keekan.bean.FriendBean;
import com.keekan.tool.BaseTools;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 好友管理Action<br>
 */
@SuppressWarnings("unchecked")
public class FriendAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private List friendGroupList;
	private List friendList;
	private List avatarList;
	private List userList;
	
	/**
	 * 好友页面初始化
	 * @return
	 * @throws Exception
	 */
	public String friend() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		friendGroupList = friendGroupServe.viewAllFriendGroup(keeno);
		friendList = friendServe.initViewFriend(keeno);
		if (friendList != null) {
			Integer[] keeno = new Integer[friendList.size()];
			int i = 0;
			for (FriendBean a : (List<FriendBean>)friendList) {
				keeno[i] = a.getFriendKeeno();
				i++;
			}
			avatarList = avatarServe.viewAllAvatar(keeno);
			//userList = userServe.viewUserByCarte(keeno);
		}
		return "friendSuccess";
	}
	
	/**
	 * 查找好友初始化[精准查找]
	 * @return
	 * @throws Exception
	 */
	public String friendFindInit() throws Exception {
		
		return "success";
	}
	
	/**
	 * 查找好友[精准查找]
	 * @return
	 * @throws Exception
	 */
	public String friendFind() throws Exception {
		
		userList = userServe.viewUser(keeno);
		avatarList = avatarServe.viewAvatar(keeno);
		
		return SUCCESS;
	}
	
	public String friendInfoCard() throws Exception {
		
		userList = userServe.viewUser(keeno);
		avatarList = avatarServe.viewAvatar(keeno);
		
		return SUCCESS;
	}
	
	public String addFriend() throws Exception {
		
		userList = userServe.viewUser(keeno);
		avatarList = avatarServe.viewAvatar(keeno);
		
		return SUCCESS;
	}
	
	/**
	 * 添加验证信息初始化
	 * @return
	 * @throws Exception
	 */
	public String addAttestInfoInit() throws Exception {
		
		userList = userServe.viewUser(keeno);
		avatarList = avatarServe.viewAvatar(keeno);
		friendGroupList = friendGroupServe.viewAllFriendGroup(keeno);
		
		return SUCCESS;
	}
	
	public void setFriendGroupList(List friendGroupList) {
		this.friendGroupList = friendGroupList;
	}

	public List getFriendGroupList() {
		return friendGroupList;
	}
	
	public List getFriendList() {
		return friendList;
	}

	public void setFriendList(List friendList) {
		this.friendList = friendList;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getAvatarList() {
		return avatarList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public List getUserList() {
		return userList;
	}
}
