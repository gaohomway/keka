package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.AlbumCoverBase;
import com.keekan.dao.AlbumCoverDao;
import com.keekan.serve.AlbumCoverServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册封面的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AlbumCoverServeImpl implements AlbumCoverServe{

	private AlbumCoverDao albumCoverDao;

	public AlbumCoverDao getAlbumCoverDao() {
		return albumCoverDao;
	}

	public void setAlbumCoverDao(AlbumCoverDao albumCoverDao) {
		this.albumCoverDao = albumCoverDao;
	}

	/**
	 * 添加相册封面
	 */
	public Integer addAlbumCover(String photoName, Integer ownAlbumId, String uploadDate, String status) throws Exception {
		try {
			AlbumCoverBase a = new AlbumCoverBase();
			a.setPhotoName(photoName);
			a.setOwnAlbumId(ownAlbumId);
			a.setUploadDate(uploadDate);
			a.setStatus(status);
			albumCoverDao.addAlbumCover(a);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加相册封面时出现异常");
		}
	}

	/**
	 * 查看相册封面
	 */
	public List viewAlbumCover(Integer[] albumIds) throws Exception {
		try {
			List albumCoverList = albumCoverDao.viewAlbumCover(albumIds);
			return albumCoverList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看封面时出现异常");
		}
	}

	/**
	 * 查看相册封面
	 */
	public List viewAlbumCover(Integer albumIds) throws Exception {
		try {
			List albumCoverList = albumCoverDao.viewAlbumCover(albumIds);
			return albumCoverList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看封面时出现异常");
		}
	}

	/**
	 * 编辑相册封面
	 */
	public Integer editAlbumCover(List<AlbumCoverBase> acb) throws Exception {
		try {
			AlbumCoverBase a = new AlbumCoverBase();
			a.setCoverId(acb.get(0).getCoverId());
			a.setPhotoName(acb.get(0).getPhotoName());
			a.setOwnAlbumId(acb.get(0).getOwnAlbumId());
			a.setUploadDate(acb.get(0).getUploadDate());
			a.setStatus(acb.get(0).getStatus());
			albumCoverDao.editAlbumCover(a);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("编辑封面时出现异常");
		}
	}
	
	/**
	 * 随机相册封面
	 */
	public List  randomAlbumCover(Integer ownAlbumId, String uploadDate) throws Exception {
		try {
			List photoList = albumCoverDao.randomAlbumCover(ownAlbumId, uploadDate);
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("随机相册封面时出现异常");
		}
	}
}
