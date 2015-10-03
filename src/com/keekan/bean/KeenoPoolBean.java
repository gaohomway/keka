package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: KEE号码池持久Bean类 <br>
 */
public class KeenoPoolBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id; 		// 主键标识
	private Integer keeno; 		// KEE号码
	
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
}
