package com.keekan.action;

import java.util.List;

import com.keekan.bean.AlbumBean;
import com.keekan.bean.AlbumGroupBean;
import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 相册Action<br>
 */
@SuppressWarnings("unchecked")
public class AlbumAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer albumId;						//相册ID
	private String albumName;						//相册的名字
	private String albumDepict;						//相册描述
	private Integer ownAlbumGroupId;				//相册所属分类
	private String albumGroupId;					//相册分类ID
	private String albumPurview;					//相册可见
	private List<AlbumBean> albumList;				//相册名字List
	private List<AlbumGroupBean> albumGroupList;	//相册分类List
	private List albumCoverList;					//相册封面List
	private Integer[] photoNumber;					//照片张数
	private String createDate;						// 创建日期
	private String updateDate;						// 更新日期
	/**
	 * 相册
	 * @return
	 * @throws Exception
	 */
	public String album() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		//查询相册分组
		albumGroupList = albumGroupServe.viewAllAlbumGroup(keeno);
		Integer[] albumGroupIds = new Integer[albumGroupList.size()];
		int i = 0;
		for (AlbumGroupBean a : (List<AlbumGroupBean>)albumGroupList) {
			albumGroupIds[i] = a.getAlbumGroupId();
			i++;
		}
		//查询相册
		albumList = albumServe.viewAllAlbum(albumGroupIds);
		//更新相册个数
		for (int j = 0; j < albumGroupIds.length; j++) {
			Integer k = 0;
			for (int m = 0; m < albumList.size(); m++) {
				if (albumGroupIds[j].equals(albumList.get(m).getOwnAlbumGroupId())) {
					 k++;
				}
			}
			albumGroupList.get(j).setAlbumNumber(k);
		}
		
		Integer[] albumIds = new Integer[albumList.size()];
		int j = 0;
		for (AlbumBean a : (List<AlbumBean>)albumList) {
			albumIds[j] = a.getAlbumId();
			j++;
		}
		//相册封面
		albumCoverList = albumCoverServe.viewAlbumCover(albumIds);
		
		//照片数目
		photoNumber = photoServe.photoNumber(albumIds);
		for (int n = 0; n < photoNumber.length; n++) {
			albumList.get(n).setPhotoNumber(photoNumber[n]);
		}
		
		if (albumList != null && albumList.size() >= 1) {
			return "albumSuccess";
		} else {
			return "albumFails";
		}
	}
	
	/**
	 * 添加相册
	 * @return
	 * @throws Exception
	 */
	public String addAlbum() throws Exception {
		
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		createDate = DateTime.getDateTime();
		updateDate = createDate;
		albumId = albumServe.addAlbum(keeno, albumName, albumDepict, Integer.valueOf(albumGroupId), createDate, updateDate);
		albumCoverServe.addAlbumCover("../../kan/photo_thum/noPhoto.png", albumId, updateDate, "a");
		return SUCCESS;
	}
	
	public String albumOfAvatar() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		albumGroupList = albumGroupServe.viewAllAlbumGroup(keeno);
		Integer[] albumGroupIds = new Integer[albumGroupList.size()];
		int i = 0;
		for (AlbumGroupBean a : (List<AlbumGroupBean>)albumGroupList) {
			albumGroupIds[i] = a.getAlbumGroupId();
			i++;
		}
		albumList = albumServe.viewAllAlbum(albumGroupIds);
		if (albumList != null && albumList.size() >= 1) {
			return SUCCESS;
		} else {
			return "albumFails";
		}
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Integer getOwnAlbumGroupId() {
		return ownAlbumGroupId;
	}

	public void setOwnAlbumGroupId(Integer ownAlbumGroupId) {
		this.ownAlbumGroupId = ownAlbumGroupId;
	}

	public String getAlbumPurview() {
		return albumPurview;
	}

	public void setAlbumPurview(String albumPurview) {
		this.albumPurview = albumPurview;
	}

	public List getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List albumList) {
		this.albumList = albumList;
	}

	public List getAlbumGroupList() {
		return albumGroupList;
	}

	public void setAlbumGroupList(List albumGroupList) {
		this.albumGroupList = albumGroupList;
	}

	public void setAlbumCoverList(List albumCoverList) {
		this.albumCoverList = albumCoverList;
	}

	public List getAlbumCoverList() {
		return albumCoverList;
	}

	public void setPhotoNumber(Integer[] photoNumber) {
		this.photoNumber = photoNumber;
	}

	public Integer[] getPhotoNumber() {
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

	public String getAlbumGroupId() {
		return albumGroupId;
	}

	public void setAlbumGroupId(String albumGroupId) {
		this.albumGroupId = albumGroupId;
	}

	public void setAlbumDepict(String albumDepict) {
		this.albumDepict = albumDepict;
	}

	public String getAlbumDepict() {
		return albumDepict;
	}
}
