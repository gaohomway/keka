package com.keekan.bean;

import java.io.Serializable;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 歌曲分组表持久化Bean类 <br>
 */
public class SongGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer songGroupId; 		// 表示ID
	private Integer keeno; 				// KEE号
	private String songGroupName; 		// 相册分组名字

	public Integer getSongGroupId() {
		return songGroupId;
	}
	public void setSongGroupId(Integer songGroupId) {
		this.songGroupId = songGroupId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getSongGroupName() {
		return songGroupName;
	}
	public void setSongGroupName(String songGroupName) {
		this.songGroupName = songGroupName;
	}
}
