package com.keekan.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.keekan.tool.ImageCut;
import com.keekan.action.BaseAction;

/**
 *  头像编辑
 * @author KEEKAN
 */
public class AvatarEditorAction extends BaseAction {
 
	private static final long serialVersionUID = 1L;
	private String x;
	private String y;
	private String w;
	private String h;
	
	private String oldImgPath;		//原始图片路径
	private String savePath;		// 接受依赖注入的属性
	private String imgFileExt;
	private String imgRoot;
	
	private Integer width;
	private Integer height;
	
	private String uploadFileName;
	
	public String execute() throws Exception {
		
		ServletContext context = ServletActionContext.getServletContext();
		String webAppPath = context.getRealPath("/");						//WEB应用程序根路径
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");//图片名称:以当前日期
		String imgFileId = formatter.format(new Date());
		uploadFileName = imgFileId + System.currentTimeMillis() + "." + imgFileExt;
		String imgName =  imgRoot + uploadFileName;	
		
		String createImgPath = webAppPath + imgName;		//组装图片真实名称
		
		webAppPath += oldImgPath;							//之前上传的图片路径
		
		System.out.println("原图片路径: " + webAppPath + ",新图片路径: " + createImgPath);
		int xs = Integer.parseInt(x); 
		int ys = Integer.parseInt(y); 
		int ws = Integer.parseInt(w); 
		int hs = Integer.parseInt(h);
		ImageCut.abscut(webAppPath, createImgPath, xs,ys,ws, hs);	//进行剪切图片操作
		
		 File f = new File(createImgPath);								
		 if(f.exists()){						
			 System.out.println("剪切图片大小: "+w+"*"+h+"图片成功!");
		 }	
		 
		String path = "/imgcrop.jsp?tag=1&oldImgPath="+oldImgPath+"&imgFileExt="+imgFileExt+"&imgRoot="+imgRoot + "&imgName="+imgName+"&height=" + height + "&width=" + width;
		System.out.println("imgCrop: " + path);
		
		return SUCCESS;
	}
	
	public void setSavePath(String value) {
		this.savePath = value;
	}
	@SuppressWarnings({ "unused", "deprecation" })
	private String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	/*public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getW() {
		return w;
	}
	public void setW(Integer w) {
		this.w = w;
	}*/
/*	public Integer getH() {
		return h;
	}
	public void setH(Integer h) {
		this.h = h;
	}*/
	public String getH() {
		return h;
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

	public void setH(String h) {
		this.h = h;
	}
	public String getOldImgPath() {
		return oldImgPath;
	}
	public void setOldImgPath(String oldImgPath) {
		this.oldImgPath = oldImgPath;
	}
	public String getImgFileExt() {
		return imgFileExt;
	}
	public void setImgFileExt(String imgFileExt) {
		this.imgFileExt = imgFileExt;
	}
	public String getImgRoot() {
		return imgRoot;
	}
	public void setImgRoot(String imgRoot) {
		this.imgRoot = imgRoot;
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
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
