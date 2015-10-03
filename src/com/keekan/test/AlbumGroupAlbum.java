package com.keekan.test;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AlbumBean;
import com.keekan.bean.AlbumGroupBean;
import com.keekan.dao.impl.AlbumGroupDaoImpl;

public class AlbumGroupAlbum extends HibernateDaoSupport {
	
	public static void main(String[] args) {
		AlbumGroupBean albumGroupBean = new AlbumGroupBean();
		albumGroupBean.setKeeno(1000);
		albumGroupBean.setAlbumGroupName("写真");
		
		AlbumBean albumBean = new AlbumBean();
		albumBean.setAlbumName("第一个相册");
		albumBean.setAlbumDescribe("这是测试添加的第一个相册");
		//albumGroupBean.getAlbumlList().add(albumBean);
		AlbumGroupDaoImpl albumGroupDaoImpl = new AlbumGroupDaoImpl();
		//albumGroupDaoImpl.viewAllAlbum(albumGroupBean);
	}
	
	

}
