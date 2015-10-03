package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户状态表持久化Bean类 <br>
 */
public class StatusBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer statusId;		// 状态ID
	private Integer keeno;			// KEE号码
	private String status;			// 状态[a:在线, b:离开, c:忙碌, d:勿打扰, e:隐身, f:离线, g:添加]
	private String statusInfo;		// 添加的信息
	private String statusDate;		// 最新状态时间
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
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
}
