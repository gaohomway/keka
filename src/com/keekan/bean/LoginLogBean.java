package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 登录记录持久化Bean类 <br>
 */
public class LoginLogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer logId;			//记录ID
	private Integer keeno;			//KEE号码
	
	private String logonType;		//登录类型
	private String loginIP;			//登录IP
	
	private String nation;			//所在国家
 	private String city;			//所在市镇
 	private String area;			//所在市区
 	
 	private String dateTime;		//日期时间
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLogonType() {
		return logonType;
	}
	public void setLogonType(String logonType) {
		this.logonType = logonType;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public Integer getKeeno() {
		return keeno;
	}
}
