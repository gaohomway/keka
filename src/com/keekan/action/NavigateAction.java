package com.keekan.action;

import java.util.List;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 导航Action<br>
 */
@SuppressWarnings("unchecked")
public class NavigateAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private List navigateList;
	
	public String viewNavigate() throws Exception {
		navigateList = navigateServe.viewNavigate();
		return "success";
	}

	public void setNavigateList(List navigateList) {
		this.navigateList = navigateList;
	}

	public List getNavigateList() {
		return navigateList;
	}

}
