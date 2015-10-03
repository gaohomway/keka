package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片封面表持久化Bean类 <br>
 */
public class AlbumCoverBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer coverId;			//封面ID
	private String photoName;			//照片名字
	private Integer ownAlbumId;			//所属相册ID
	private String uploadDate;			//上传时间
	private String status;				// 状态[a:初始化添加, b:随机生成, c:用户设置]
	
	public Integer getCoverId() {
		return coverId;
	}
	public void setCoverId(Integer coverId) {
		this.coverId = coverId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
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
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	 
}
