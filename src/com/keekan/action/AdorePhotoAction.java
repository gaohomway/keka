package com.keekan.action;

import java.util.List;

import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 倾心Action<br>
 */
@SuppressWarnings("unchecked")
public class AdorePhotoAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private String uploadDate;					//上传日期
	private String uploadTime;					//上传时间
	private List adorePhotoList;				// 
	
	/**
	 * 插入照片初始化
	 * @return
	 * @throws Exception
	 */
	public String insertPhoto() throws Exception {
		uploadDate = DateTime.getYMD();
		uploadTime = DateTime.getHMS();
		return "success";
	}
	
	/**
	 * 插入照片缩略图
	 * @return
	 * @throws Exception
	 */
	public String insertPhotoThum() throws Exception {
		 
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		String createDate = uploadDate +" "+ uploadTime;
		adorePhotoList = adorePhotoServe.insertPhotoThum(keeno, createDate);
		return SUCCESS;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public void setAdorePhotoList(List adorePhotoList) {
		this.adorePhotoList = adorePhotoList;
	}

	public List getAdorePhotoList() {
		return adorePhotoList;
	}
}
