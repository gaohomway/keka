package com.keekan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

public class PhotoUpload5Action extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String title;
	private File[] file;
	private String[] uploadContentType;
	private String[] uploadFileName;
	private String savePath;			// 接受依赖注入的属性
	
	public String photoUpload() throws Exception {
		File[] files = getFile();
		for (int i = 0; i < files.length; i++) {
			// 以服务器的文件保存地址和原文件名建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName()[i]);
			FileInputStream fis = new FileInputStream(files[i]);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		}
		return SUCCESS;
	}
	
	public void setSavePath(String value) {
		this.savePath = value;
	}
	@SuppressWarnings("deprecation")
	private String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getTitle() {
		return (this.title);
	}
/*	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public File[] getUpload() {
		return (this.upload);
	}*/
	public String[] getUploadContentType() {
		return (this.uploadContentType);
	}
	public String[] getUploadFileName() {
		return (this.uploadFileName);
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public File[] getFile() {
		return file;
	}
}