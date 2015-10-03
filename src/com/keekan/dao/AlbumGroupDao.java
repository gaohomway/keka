package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AlbumGroupBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册分类的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumGroupDao {
	
	
	/**
	 * 添加相册分类
	 * @param albumGroupBean
	 * @return
	 */
	Integer addAlbumGroup(AlbumGroupBean albumGroupBean);
	
	/**
	 * 删除相册分类
	 * @param albumGroupBean
	 * @return
	 */
	Integer deleteAlbumGroup(AlbumGroupBean albumGroupBean);
	
	/**
	 * 编辑相册分类
	 * @param albumGroupBean
	 * @return
	 */
	Integer editAlbumGroup(AlbumGroupBean albumGroupBean);
	
	/**
	 * 查看全部相册
	 * @param keeno 
	 */
	List viewAllAlbumGroup(Integer keeno);
}
