package com.keekan.bean;

import java.io.Serializable;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 倾心持久化Bean<br>
 */
public class AdoreBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer adoreId; 			// 表示ID
	private Integer keeno;				// KEE号码
	private String content; 			// 内容
	private String createDate;			// 创建日期
	
	public Integer getAdoreId() {
		return adoreId;
	}
	public void setAdoreId(Integer adoreId) {
		this.adoreId = adoreId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
