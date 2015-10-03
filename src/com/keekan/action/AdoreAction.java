package com.keekan.action;

import java.util.List;

import com.keekan.bean.AdoreBean;
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
public class AdoreAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private Integer adoreId; 			// 表示ID
	private String content;				//倾心内容
	private String createDate;			//创建时间
	private List adoreList;				//倾心内容
	private List adorePhotoList;		//倾心照片
	
	/**
	 * 倾心
	 * @return
	 * @throws Exception
	 */
	public String adore() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		adoreList = adoreServe.viewAdore(keeno);
		if (adoreList != null) {
			Integer[] adoreIds = new Integer[adoreList.size()];
			int i = 0;
			for (AdoreBean a : (List<AdoreBean>)adoreList) {
				adoreIds[i] = a.getAdoreId();
				i++;
			}
			adorePhotoList = adorePhotoServe.viewAdorePhoto(adoreIds);
		}
		return "success";
	}
	
	/**
	 * 添加倾心
	 * @return
	 * @throws Exception
	 */
	public String addAdore() throws Exception {
		
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		String createDates = DateTime.getDateTime();
		adoreId = adoreServe.addAdore(keeno, content, createDates);
		adoreServe.renewAdore(adoreId, keeno, createDate);
		
		adoreList = adoreServe.viewAdore(adoreId);
		Integer[] adoreId = new Integer[1];
		adoreId[0] = this.adoreId;
		adorePhotoList = adorePhotoServe.viewAdorePhoto(adoreId);
		
		return SUCCESS;
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
	public void setAdoreId(Integer adoreId) {
		this.adoreId = adoreId;
	}
	public Integer getAdoreId() {
		return adoreId;
	}
	public List getAdoreList() {
		return adoreList;
	}
	public void setAdoreList(List adoreList) {
		this.adoreList = adoreList;
	}
	public List getAdorePhotoList() {
		return adorePhotoList;
	}
	public void setAdorePhotoList(List adorePhotoList) {
		this.adorePhotoList = adorePhotoList;
	}
}
