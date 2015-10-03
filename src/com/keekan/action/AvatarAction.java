package com.keekan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.keekan.tool.BaseTools;
import com.keekan.tool.Configurats;
import com.keekan.tool.DateTime;
import com.keekan.tool.ImageCut;
import com.keekan.tool.ImageManager;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 头像处理Action<br>
 */
@SuppressWarnings("unchecked")
public class AvatarAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private File photo;				//照片域
	private String photoFileName;	//照片名
	private String photoType;
	private String avatarPath;
	private String avatarName;		
	private String rawName;			//原名字
	private String shrinkName;		//压缩后的名字
	private String cutName;			//切割后的名字
	private String rawPath;			//上传后原图片地址//raw
	private String shrinkPath;		//上传后压缩图片地址//Shrink
	private String dataName;		//时间名字
	
	private String x;
	private String y;
	private String w;
	private String h;
	private Integer width;
	private Integer height;
	private String photoName;
	
	private Integer belongAlbumId;
	private String uploadDate;

	private List avatarList;		//头像List
	/**
	 * 头像
	 * @return
	 * @throws Exception
	 */
	public String avatar() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		avatarList = avatarServe.viewAllAvatar(keeno);
		return "success";
	}
	
	/**
	 * 头像编辑
	 * @return
	 * @throws Exception
	 */
	public String avatarEditor() throws Exception {
		
		return "success";
	}
	/**
	 * 头像上传
	 * @return
	 * @throws Exception
	 */
	public String avatarUpload() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		avatarPath = Configurats.getFilePath("USER_FILE")+keeno+"/avatar/";
		photoType = photoFileName.substring(photoFileName.lastIndexOf("."));
		dataName = DateTime.getYearMonthDay();
		avatarName = dataName+"_r"+photoType;
		shrinkName = dataName+"_s"+photoType;
		FileOutputStream fos = new FileOutputStream(avatarPath+avatarName);
		FileInputStream fis = new FileInputStream(getPhoto());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		belongAlbumId  = albumServe.getAlbumId(keeno, "贴图相册");
		uploadDate = DateTime.getDateTime();
		photoServe.photoUpload(photoFileName, avatarName, "", belongAlbumId, uploadDate);
		rawPath = avatarPath+avatarName;
		shrinkPath = avatarPath+shrinkName;
		
		ImageManager imageManager = new ImageManager();
		boolean dis = imageManager.zoomImg(imageManager, rawPath, shrinkPath, 770, 350);
		
		if (dis == true) {
			avatarName = shrinkName;
		}
		HttpServletResponse response = BaseTools.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(keeno +"#"+ avatarName );
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 头像切割
	 * @return
	 * @throws Exception
	 */
	public String avatarCut() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		avatarPath = Configurats.getFilePath("USER_FILE")+keeno+"/avatar/";
		photoType = photoName.substring(photoName.lastIndexOf("."));
		dataName = DateTime.getYearMonthDay();
		rawName = avatarPath+photoName;
		avatarName = avatarPath+dataName+"_c"+photoType;
		
		int xs = Integer.parseInt(x); 
		int ys = Integer.parseInt(y); 
		int ws = Integer.parseInt(w); 
		int hs = Integer.parseInt(h);
		ImageCut.abscut(rawName, avatarName, xs,ys,ws, hs);	//进行剪切图片操作
		String[] avatarNames = new String[3];
		 for (int i = 0; i <= 2; i++) {
			 if (i == 0) {
				cutName = dataName+"_100"+photoType;
				width = 100;
				height = 100;
			}else if (i == 1) {
				cutName = dataName+"_50"+photoType;
				width = 50;
				height = 50;
			}else if (i == 2) {
				cutName = dataName+"_30"+photoType;
				width = 30;
				height = 30;
			}
			avatarNames[i] = cutName;
			ImageManager imageManager = new ImageManager();
			imageManager.zoomImg(imageManager, avatarName, avatarPath + cutName, width, height);
			
		}
		 uploadDate = DateTime.getDateTime();
		 //avatarServe.initAddAvatar(keeno, avatarNames[0], avatarNames[1], avatarNames[2], uploadDate, "yes");
		 avatarServe.renewAvatar(keeno, avatarNames[0], avatarNames[1], avatarNames[2], uploadDate, "yes");
		 File f = new File(avatarName);								
		 if(f.exists()){						
			 
		 }	
		return SUCCESS;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getAvatarPath() {
		return avatarPath;
	}
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	public String getAvatarName() {
		return avatarName;
	}
	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
	public String getRawName() {
		return rawName;
	}
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
	public String getShrinkName() {
		return shrinkName;
	}
	public void setShrinkName(String shrinkName) {
		this.shrinkName = shrinkName;
	}
	public String getRawPath() {
		return rawPath;
	}
	public void setRawPath(String rawPath) {
		this.rawPath = rawPath;
	}
	public String getShrinkPath() {
		return shrinkPath;
	}
	public void setShrinkPath(String shrinkPath) {
		this.shrinkPath = shrinkPath;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public void setCutName(String cutName) {
		this.cutName = cutName;
	}
	public String getCutName() {
		return cutName;
	}

	public void setBelongAlbumId(Integer belongAlbumId) {
		this.belongAlbumId = belongAlbumId;
	}

	public Integer getBelongAlbumId() {
		return belongAlbumId;
	}
	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getAvatarList() {
		return avatarList;
	}

}