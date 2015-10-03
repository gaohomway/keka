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
public class SongBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer songId; 			// 表示ID
	private String song; 				// 歌曲
	private String Singer; 				// 歌手
	private Integer albums; 			// 专辑
	//private url
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSinger() {
		return Singer;
	}
	public void setSinger(String singer) {
		Singer = singer;
	}
	public Integer getAlbums() {
		return albums;
	}
	public void setAlbums(Integer albums) {
		this.albums = albums;
	}
}
