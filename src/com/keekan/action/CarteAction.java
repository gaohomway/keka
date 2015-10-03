package com.keekan.action;

import java.util.List;
import java.util.Map;

import com.keekan.tool.BaseTools;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 名片Action<br>
 */
@SuppressWarnings("unchecked")
public class CarteAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private List avatarList;			//头像List
	private List userList;				//用户List
	
	public String carte() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		StatusAction statusAction = new StatusAction();
		
		/*statusAction.online();
		statusAction.leave();
		statusAction.busy();*/
		FirePush firePush = new FirePush();
		firePush.myBroadcast();
		firePush.myMulticast();
		firePush.myUnicast();
		
		avatarList = avatarServe.viewAvatar(keeno);
		userList = userServe.viewUser(keeno);
		
		return "carteSuccess";
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
