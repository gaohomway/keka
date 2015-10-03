package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 登录持久化Bean类 <br>
 */
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;			//ID
	private Integer keeno;		//KEE号码
	private String password;	//密码

	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
}
