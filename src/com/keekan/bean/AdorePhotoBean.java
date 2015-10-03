package com.keekan.bean;

import java.io.Serializable;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 倾心图片持久化Bean<br>
 */
public class AdorePhotoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer adorePhotoId; 			// 表示ID
	private Integer keeno;					// KEE号码
	private Integer ownAdoreId;				// 倾心信息ID
	private String rawPhotoName;			// 原照片名
	private String photoName;				// 照片名
	private String createDate;				// 创建时间
	
	public Integer getAdorePhotoId() {
		return adorePhotoId;
	}
	public void setAdorePhotoId(Integer adorePhotoId) {
		this.adorePhotoId = adorePhotoId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getRawPhotoName() {
		return rawPhotoName;
	}
	public void setRawPhotoName(String rawPhotoName) {
		this.rawPhotoName = rawPhotoName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setOwnAdoreId(Integer ownAdoreId) {
		this.ownAdoreId = ownAdoreId;
	}
	public Integer getOwnAdoreId() {
		return ownAdoreId;
	}
}
