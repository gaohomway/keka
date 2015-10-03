package com.keekan.action;

import org.apache.struts2.ServletActionContext;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */
@SuppressWarnings("deprecation")
public class PictureAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File[] picdata; // 文件域
	private String pictitle; //

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String filePath = "upload";
		String realPath = request.getRealPath("\\") + filePath;

		File dir = new File(realPath);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		File[] files = getPicdata();
		for (int i = 0; i < files.length; i++) {
			FileOutputStream fos = new FileOutputStream(realPath + "\\" + getPictitle());
			FileInputStream fis = new FileInputStream(files[i]);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		}
		return null;
	}

	public File[] getPicdata() {
		return picdata;
	}
	public void setPicdata(File[] picdata) {
		this.picdata = picdata;
	}
	public String getPictitle() {
		return pictitle;
	}
	public void setPictitle(String pictitle) {
		this.pictitle = pictitle;
	}
}