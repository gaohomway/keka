package com.keekan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.keekan.bean.AlbumGroupBean;
import com.keekan.bean.FriendBean;
import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: Myka Action<br>
 */
@SuppressWarnings("unchecked")
public class MykaAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private List navigateList;		//导航List
	private List friendList;		//好友List
	private Integer statusId;		// 状态ID
	private String status;			// 状态[a:在线, b:离开, c:忙碌, d:勿打扰, e:隐身, f:离线, g:添加]
	private String statusInfo;		// 添加的信息
	private String statusDate;		// 最新状态时间
	private List avatarList;		//头像List
	private Integer vkeeno;			//访客号码
	private String host;			//主人[yes||no]
	
	/**
	 * Myka page initialization
	 * @return
	 * @throws Exception
	 */
	public String myka() throws Exception {
		HttpServletRequest request = BaseTools.getRequest();
		vkeeno = (Integer) request.getSession().getAttribute("keeno");
		//keeno = Integer.valueOf(request.getParameter("vkeeno"));
		
		if (vkeeno != null) {				//已登录
			if (vkeeno == keeno) {
				//本人访问并且已登录
				host = "yes";
				keeno = vkeeno;
			}else {
				//不是本人访问并且已登录
				host = "no";
			}
		}else if (vkeeno == null) {			//未登录
			
		}
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		statusDate = DateTime.getDateTime();
		statusId = statusServe.updateStatus(keeno, "a", statusInfo, statusDate);
		
		friendList = friendServe.onlineNotice(keeno);
		
		if (friendList != null) {
			Integer[] keenos = new Integer[friendList.size()];
			int i = 0;
			for (FriendBean f : (List<FriendBean>)friendList) {
				keenos[i] = f.getKeeno();
				i++;
			}
			StatusAction statusAction = new StatusAction();
			//statusAction.online(keeNumbers, keeNumber);
		}
		
		avatarList = avatarServe.viewAvatar(keeno);
		navigateList = navigateServe.viewNavigate();
		if (navigateList != null) {
			return "mykaSuccess";
		}else {
			return "mykaFails";
		}
		
	}
	public void setNavigateList(List navigateList) {
		this.navigateList = navigateList;
	}
	public List getNavigateList() {
		return navigateList;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public void setFriendList(List friendList) {
		this.friendList = friendList;
	}
	public List getFriendList() {
		return friendList;
	}
	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}
	public List getAvatarList() {
		return avatarList;
	}
	public void setVkeeno(Integer vkeeno) {
		this.vkeeno = vkeeno;
	}
	public Integer getVkeeno() {
		return vkeeno;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getHost() {
		return host;
	}
}
