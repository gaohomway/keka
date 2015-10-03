package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册表持久化Bean类 <br>
 */
public class AlbumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer albumId; 			// 表示ID
	private Integer keeno;				// KEE号码
	private String albumName; 			// 相册的名字
	private String albumDescribe; 		// 相册描述
	private Integer ownAlbumGroupId; 	// 所属相册分类ID
	private String createDate;			// 创建日期
	private String updateDate;			// 更新日期
	private Integer photoNumber;		// 照片张数[未持久化]
	
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumDescribe() {
		return albumDescribe;
	}
	public void setAlbumDescribe(String albumDescribe) {
		this.albumDescribe = albumDescribe;
	}
	public Integer getOwnAlbumGroupId() {
		return ownAlbumGroupId;
	}
	public void setOwnAlbumGroupId(Integer ownAlbumGroupId) {
		this.ownAlbumGroupId = ownAlbumGroupId;
	}
	public void setPhotoNumber(Integer photoNumber) {
		this.photoNumber = photoNumber;
	}
	public Integer getPhotoNumber() {
		return photoNumber;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
}
