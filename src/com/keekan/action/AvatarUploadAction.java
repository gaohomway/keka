package com.keekan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.struts2.ServletActionContext;
import com.keekan.action.BaseAction;
import com.keekan.tool.ImageZoom;

public class AvatarUploadAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;		// 接受依赖注入的属性
	
	public String execute() throws Exception {

		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		ImageZoom.resizePicture(getSavePath() + "\\" + getUploadFileName(), getSavePath() + "\\" + getUploadFileName(), 300, 300);
		return "success";
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

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getTitle() {
		return (this.title);
	}

	public File getUpload() {
		return (this.upload);
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}
}