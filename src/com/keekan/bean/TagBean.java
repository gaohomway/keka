package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签持久化Bean类 <br>
 */
public class TagBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tagId;		//标签ID
	private String tagName;		//标签名字
	private String tagDepict;	//标签描述
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagDepict() {
		return tagDepict;
	}
	public void setTagDepict(String tagDepict) {
		this.tagDepict = tagDepict;
	}
}
