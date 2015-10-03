package com.keekan.action;

import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 添加好友认证信息Action<br>
 */
public class AttestInfoAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private Integer infoId;				//验证信息ID
	private String friendKeeno;			//好友号码
	private String remarkInfo;			//备注信息
	private String groupId;				//分组ID
	private String attestInfo;			//验证信息
	private String infoDate;			//添加时间
	
	/**
	 * 添加验证信息
	 * @return
	 * @throws Exception
	 */
	public String addAttestInfo() throws Exception{
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		infoDate = DateTime.getDateTime();
		infoId = attestInfoServe.addAlbumCover(keeno, Integer.valueOf(groupId), Integer.valueOf(friendKeeno), remarkInfo, attestInfo, "a", infoDate);
		friendServe.addFriend(keeno, Integer.valueOf(friendKeeno), Integer.valueOf(groupId), remarkInfo);
		
		return SUCCESS;
	}
	
	public String getFriendKeeno() {
		return friendKeeno;
	}
	public void setFriendKeeno(String friendKeeno) {
		this.friendKeeno = friendKeeno;
	}
	public String getRemarkInfo() {
		return remarkInfo;
	}
	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}
	public String getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getAttestInfo() {
		return attestInfo;
	}
	public void setAttestInfo(String attestInfo) {
		this.attestInfo = attestInfo;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public Integer getInfoId() {
		return infoId;
	}
}
