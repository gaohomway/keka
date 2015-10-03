package com.keekan.bean;

import java.io.Serializable;
/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 添加好友认证信息持久化Bean类 <br>
 */
public class AttestInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer infoId;			//信息ID
	private Integer keeno;			//KEE号码
	private Integer groupId;		//分组ID
	private Integer friendKeeno;	//好友KEE号码
	private String remarkInfo;		//备注信息
	private String attestInfo;		//验证信息
	private String infoStatus;		//a:未处理 , b:同意, c:拒绝, d:忽略, e:同意并添加
	private String infoDate;		//添加时间
	
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
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
	public String getAttestInfo() {
		return attestInfo;
	}
	public void setAttestInfo(String attestInfo) {
		this.attestInfo = attestInfo;
	}
	public String getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}
	public String getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}
	public String getRemarkInfo() {
		return remarkInfo;
	}
}
