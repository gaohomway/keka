package com.keekan.action;

import java.util.List;


/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 标签Action<br>
 */
@SuppressWarnings("unchecked")
public class TagAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private List tagList;		//标签List
	private List tagsList;		//标签库List
	
	
	public String tag() throws Exception {
		tagList = tagServe.tag();
		tagsList = tagServe.tags();
		return SUCCESS;
	}
	
	public List getTagList() {
		return tagList;
	}
	public void setTagList(List tagList) {
		this.tagList = tagList;
	}
	public List getTagsList() {
		return tagsList;
	}
	public void setTagsList(List tagsList) {
		this.tagsList = tagsList;
	}
}
