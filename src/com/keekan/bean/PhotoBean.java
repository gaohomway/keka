package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片表持久化Bean类 <br>
 */
public class PhotoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer photoId;			//照片ID
	private String rawPhotoName;		//原照片名
	private String photoName;			//照片名
	private String photoDescription;	//照片描述
	private Integer ownAlbumId;			//所属相册ID
	private String uploadDate;			//上传时间
	
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
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
	public String getPhotoDescription() {
		return photoDescription;
	}
	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}
	public Integer getOwnAlbumId() {
		return ownAlbumId;
	}
	public void setOwnAlbumId(Integer ownAlbumId) {
		this.ownAlbumId = ownAlbumId;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
}
