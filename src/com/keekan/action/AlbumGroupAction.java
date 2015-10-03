package com.keekan.action;

import com.keekan.tool.BaseTools;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 * Copyright (C), 2012-, keekan.com <br>
 * This program is protected by copyright laws. <br>
 * Program Name: KEEKAN<br>
 * Class Name: 相册分组处理Action <br>
 */ 
public class AlbumGroupAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String albumGroupName;	//相册名字
	private Integer albumGroupId;	//相册分组ID
	
	/**
	 * 添加相册分组
	 * @return
	 * @throws Exception
	 */
	public String addAlbumGroup() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		albumGroupId = albumGroupServe.addAlbumGroup(keeno, albumGroupName);
		return SUCCESS;
	}

	/**
	 * 删除相册分组
	 * @return
	 * @throws Exception
	 */
	public String deleteAlbumGroup() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		albumGroupId = albumGroupServe.deleteAlbumGroup(keeno, albumGroupId);
		return SUCCESS;
	}

	/**
	 * 编辑相册分组
	 * @return
	 * @throws Exception
	 */
	public String editAlbumGroup() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		albumGroupServe.editAlbumGroup(keeno, albumGroupId, albumGroupName);
		return SUCCESS;
	}

	/**
	 * 查看相册分组
	 * @return
	 * @throws Exception
	 */
	public String viewAlbumGroup() throws Exception {
		
		return null;
	}
	public String getAlbumGroupName() {
		return albumGroupName;
	}
	public void setAlbumGroupName(String albumGroupName) {
		this.albumGroupName = albumGroupName;
	}
	public void setAlbumGroupId(Integer albumGroupId) {
		this.albumGroupId = albumGroupId;
	}
	public Integer getAlbumGroupId() {
		return albumGroupId;
	}
	
}
