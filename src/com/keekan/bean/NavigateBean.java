package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 导航表持久化Bean类 <br>
 */
public class NavigateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer navigateId; 		// 导航ID
	private String navigateName; 		// 导航名字
	private String navigateURL;			// 导航地址
	private String navigateIcon; 		// 导航图标
	private Integer navigateSorting; 	// 导航排序
	
	public Integer getNavigateId() {
		return navigateId;
	}
	public void setNavigateId(Integer navigateId) {
		this.navigateId = navigateId;
	}
	public String getNavigateName() {
		return navigateName;
	}
	public void setNavigateName(String navigateName) {
		this.navigateName = navigateName;
	}
	public String getNavigateURL() {
		return navigateURL;
	}
	public void setNavigateURL(String navigateURL) {
		this.navigateURL = navigateURL;
	}
	public String getNavigateIcon() {
		return navigateIcon;
	}
	public void setNavigateIcon(String navigateIcon) {
		this.navigateIcon = navigateIcon;
	}
	public Integer getNavigateSorting() {
		return navigateSorting;
	}
	public void setNavigateSorting(Integer navigateSorting) {
		this.navigateSorting = navigateSorting;
	}
}
