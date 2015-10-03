package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 名片[大|小]持久化Bean类 <br>
 */
public class CarteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer keeno;			//KEE号码
 	private String nickname;		//昵称
 	private String bigAvatar;		//大头像100*100
	private String midAvatar;		//中头像50*50
	private String smallAvatar;		//小头像30*30
 	private String sex;				//性别
 	private String birthday;		//生日
 	private String country;			//所在国家
 	private String town;			//所在市镇
 	private String district;		//所在市区
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
}
