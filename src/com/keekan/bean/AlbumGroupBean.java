package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册分组表持久化Bean类 <br>
 */
public class AlbumGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer  albumGroupId; 		// 表示ID
	private Integer keeno; 				// KEE号
	private String albumGroupName; 		// 相册分组名字
	private Integer albumNumber;		// 相册个数(未持久化)
	
	public Integer getAlbumGroupId() {
		return albumGroupId;
	}
	public void setAlbumGroupId(Integer albumGroupId) {
		this.albumGroupId = albumGroupId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getAlbumGroupName() {
		return albumGroupName;
	}
	public void setAlbumGroupName(String albumGroupName) {
		this.albumGroupName = albumGroupName;
	}
	public void setAlbumNumber(Integer albumNumber) {
		this.albumNumber = albumNumber;
	}
	public Integer getAlbumNumber() {
		return albumNumber;
	}
}
