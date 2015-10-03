package com.keekan.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.keekan.serve.PhotoServe;
import com.keekan.tool.Configurats;
import com.keekan.tool.ImageManager;

public class PhotoUploadAction extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer keeno = (Integer) request.getSession().getAttribute("keeno");
		String userFilePath = Configurats.getFilePath("USER_FILE");
		
		File dir = new File(userFilePath+keeno+"/photo");
		
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory dff = new DiskFileItemFactory();
			dff.setRepository(dir);
			dff.setSizeThreshold(1024000);
			ServletFileUpload sfu = new ServletFileUpload(dff);
			FileItemIterator fii = null;
			try {
				fii = sfu.getItemIterator(request);
				String rawPhotoName = "";			//原照片名
				String photoName = "";				//照片名
				String photoDescription = "";		//照片描述
				Integer ownAlbumId = 0;				//所属相册ID
				String uploadDate = "";				//上传日期
				String uploadTime = "";				//上传时间
				String title = ""; 					// 图片标题
				String url = ""; 					// 图片地址
				
				String originalName = "";
				String state = "SUCCESS";
				String photoType = "";

				while (fii.hasNext()) {
					FileItemStream fis = fii.next();
					if (!fis.isFormField() && fis.getName().length() > 0) {
						rawPhotoName = fis.getName();
						Pattern reg = Pattern.compile("[.]jpg|png|jpeg|gif$");
						Matcher matcher = reg.matcher(rawPhotoName);
						if (!matcher.find()) {
							state = "文件类型不允许！";
							break;
						}
						photoType = matcher.group();
						photoName = new Date().getTime() + photoType;
						url = userFilePath+keeno+"/photo/" + photoName;
						BufferedInputStream in = new BufferedInputStream(fis.openStream());	// 获得文件输入流
						FileOutputStream a = new FileOutputStream(new File(url));
						BufferedOutputStream output = new BufferedOutputStream(a);
						Streams.copy(in, output, true);										// 开始把文件写到你指定的上传文件夹
						
						//开始存入数据库
						//真是照片名：dateFileName;
						//原照片名：fileName;
						//照片描述：photoDescription
						//上传时间：
						WebApplicationContext ctx= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
						PhotoServe photoServe = (PhotoServe)ctx.getBean("photoServe");
						photoServe.photoUpload(rawPhotoName, photoName, photoDescription, ownAlbumId, uploadDate+" "+uploadTime);
						
						//生成缩略图
						ImageManager imageManager = new ImageManager();
						imageManager.thumbnail(imageManager, userFilePath+keeno+"/photo/"+photoName, userFilePath+keeno+"/photo_thum/"+photoName, 200, 9000);
						
					} else {
						String fname = fis.getFieldName();
						BufferedInputStream in = new BufferedInputStream(fis.openStream());
						byte c[] = new byte[10];
						int n = 0;
						while ((n = in.read(c)) != -1) {
							String fieldValue = new String(c, 0, n);
							if (fname.equals("photoDescription")) {
								photoDescription = fieldValue;
							}else if (fname.equals("fileName")) {
								rawPhotoName = fieldValue;
							}else if (fname.equals("belongAlbumId")) {
								ownAlbumId = Integer.valueOf(fieldValue);
							}else if (fname.equals("uploadDate")) {
								uploadDate = fieldValue;
							}else if (fname.equals("uploadTime")) {
								uploadTime = fieldValue;
							}
							break;
						}
						in.close();
					}
				}
				title = title.replace("&", "&amp;").replace("'", "&qpos;").replace( "\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;");
				response.getWriter().print("{'original':'" + originalName + "','url':'" + "/" + rawPhotoName + "','title':'" + title + "','state':'" + state + "'}");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
