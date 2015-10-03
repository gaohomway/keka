package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 头像表持久化Bean类 <br>
 */
public class AvatarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer avatarId; 		// 表示ID
	private Integer keeno; 			// KEE号
	private String bigAvatar;		//大头像100*100
	private String midAvatar;		//中头像50*50
	private String smallAvatar;		//小头像30*30
	private String updateDate;		//更新时间
	private String inuse;			//在使用[yes/null]
	
	public Integer getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getBigAvatar() {
		return bigAvatar;
	}
	public void setBigAvatar(String bigAvatar) {
		this.bigAvatar = bigAvatar;
	}
	public String getMidAvatar() {
		return midAvatar;
	}
	public void setMidAvatar(String midAvatar) {
		this.midAvatar = midAvatar;
	}
	public String getSmallAvatar() {
		return smallAvatar;
	}
	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public void setInuse(String inuse) {
		this.inuse = inuse;
	}
	public String getInuse() {
		return inuse;
	}
}
