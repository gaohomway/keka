package com.keekan.bean;

import java.io.Serializable;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签库持久化Bean类 <br>
 */
public class TagsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tagsId;			//标签ID
	private String tagsName;		//标签名字
	private Integer ownTagId;		//所属标签ID
	
	public Integer getTagsId() {
		return tagsId;
	}
	public void setTagsId(Integer tagsId) {
		this.tagsId = tagsId;
	}
	public String getTagsName() {
		return tagsName;
	}
	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}
	public Integer getOwnTagId() {
		return ownTagId;
	}
	public void setOwnTagId(Integer ownTagId) {
		this.ownTagId = ownTagId;
	}
}
