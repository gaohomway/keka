package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.AlbumBean;
import com.keekan.dao.AlbumDao;
import com.keekan.serve.AlbumServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AlbumServeImpl implements AlbumServe {

	private AlbumDao albumDao;
	/**
     * 添加相册
     * @param albumName 相册的名字
     * @param albumDescribe 相册描述
     * @param albumGroup 相册所属分类
     * @param albumGroupId 相册分类ID
     * @return 新增相册的ID
     */
	public Integer addAlbum(Integer keeno, String albumName, String albumDescribe, Integer ownAlbumGroupId, String  createDate, String updateDate) throws Exception {
		try {
			AlbumBean a = new AlbumBean();
			a.setKeeno(keeno);
			a.setAlbumName(albumName);
			a.setAlbumDescribe(albumDescribe);
			a.setOwnAlbumGroupId(ownAlbumGroupId);
			a.setCreateDate(createDate);
			a.setUpdateDate(updateDate);
			albumDao.addAlbum(a);
			return a.getAlbumId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加相册时出现异常！");
		}
	}
	
	/**
     * 查看全部相册
     * @param keenum KEE号
     * @return 新增相册的ID
     */
	
	public List viewAllAlbum(Integer[] albumGroupIds) throws Exception {
		try {
			List albumList = albumDao.viewAllAlbum(albumGroupIds);
			return albumList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看全部相册时出现异常！");
		}
	}
	
	/**
	 * 根据KEE号码查询所有相册
	 * @param keeno
	 * @return
	 */
	public List viewAllAlbumByKeeno(Integer keeno) throws Exception {
		try {
			List albumNameList = albumDao.viewAllAlbumByKeeno(keeno);
			return albumNameList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("根据KEE号码查看全部相册！");
		}
	}
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	/**
	 * 获取相册ID
	 */
	public Integer getAlbumId(Integer keeno, String albumName) throws Exception {
		try {
			List albumList = albumDao.getAlbumId(keeno, albumName);
			return (Integer) albumList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取相册ID异常！");
		}
	}

	/**
	 * 根据相册ID查询相册
	 */
	public List viewAlbumByAlbumId(Integer albumId) throws Exception {
		try {
			List albumList = albumDao.viewAlbumByAlbumId(albumId);
			return albumList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("根据相册ID查询相册异常！");
		}
	}
}
