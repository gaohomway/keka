package com.keekan.tool;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.ResampleOp;

public class ImageManager {

	/**
	 * read image from file, now it can support image type:
	 * bmp,wbmp,gif,jpge,png
	 * @param file
	 * @return BufferedImage
	 *         <pre>
	 * BufferedImage image;
	 * image = ImageUtils.readImage(new File(&quot;myImage.jpg&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.gif&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.bmp&quot;));
	 * image = ImageUtils.readImage(new File(&quot;myImage.png&quot;));
	 * </pre>
	 */
	public BufferedImage readImage(File file) {
		BufferedImage image = null;
		if (file != null && file.isFile() && file.exists()) {
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {

			}
		}
		return image;
	}

	/**
	 * get the image width
	 * @param image
	 * @return image width
	 */
	public double getWidth(BufferedImage image) {
		return image.getWidth();
	}

	/**
	 * get the image height
	 * @param image
	 * @return image height
	 */
	public double getHeight(BufferedImage image) {
		return image.getHeight();
	}

	/**
	 * @param image BufferedImage.
	 * @param width zoom width.
	 * @param heigth zoom heigth.
	 * @return BufferedImage
	 */
	public BufferedImage zoom(BufferedImage image, int width, int heigth) {
		ResampleOp resampleOp = new ResampleOp(width, heigth);
		BufferedImage tag = resampleOp.filter(image, null);
		return tag;
	}

	/**
	 * 
	 * @param image BufferedImage
	 * @param width zoom width.
	 * @param heigth zoom heigth.
	 * @return double array.double[0]:width,double[1]:heigth.
	 */
	public double[] zoomSize(BufferedImage image, double width, double heigth) {
		double[] zoomSize = new double[2];
		double srcWidth = getWidth(image);
		double srcHeigth = getHeight(image);
		if (srcWidth >= srcHeigth) {
			zoomSize[0] = (heigth / srcHeigth ) * srcWidth;
			zoomSize[1] = (heigth / srcHeigth ) * srcHeigth;
		}
		if (srcWidth <= srcHeigth) {
			zoomSize[0] = (heigth / srcHeigth ) * srcWidth;
			zoomSize[1] = heigth;
		}
		return zoomSize;
	}

	/**
	 * 
	 * Output to file out according to the style<code>BufferedImage</code> If
	 * can not appoint image or formateName or file out ,do nothing. Now it can
	 * support image type：bmp,wbmp,jpeg,png.
	 * @param image BufferedImage.
	 * @param formatName format name.
	 * @param out output path.
	 * @throws IOException IOException
	 */
	public void writeImage(BufferedImage image, String formatName, File file) throws IOException {
		if (image != null && formatName != null && !"".equals(formatName) && file != null) {
			ImageIO.write(image, formatName, file);
		}
	}

	
	public boolean zoomImg(ImageManager imageManager,String file1, String file2, double w, double h) throws IOException {
		BufferedImage image = imageManager.readImage(new File(file1));
		
		double srcWidth = getWidth(image);
		double srcHeigth = getHeight(image);
		
		if (srcWidth > w || srcHeigth > h) {
			double[] size = imageManager.zoomSize(image, w, h);
			imageManager.writeImage(imageManager.zoom(image, (int) size[0], (int) size[1]), "jpg", new File(file2));
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 生成缩略图
	 * @param imageManager
	 * @param file1
	 * @param file2
	 * @param w
	 * @param h
	 * @return
	 * @throws IOException
	 */
	public boolean thumbnail(ImageManager imageManager,String file1, String file2, double w, double h) throws IOException {
		BufferedImage image = imageManager.readImage(new File(file1));
 
		double[] size = imageManager.thumbnailSize(image, w, h);
		imageManager.writeImage(imageManager.zoom(image, (int) size[0], (int) size[1]), "jpg", new File(file2));
		return true;
	}
	
	/**
	 * 生成缩略图调整大小
	 * @param image
	 * @param width
	 * @param heigth
	 * @return
	 */
	public double[] thumbnailSize(BufferedImage image, double width, double heigth) {
		double[] zoomSize = new double[2];
		double srcWidth = getWidth(image);
		double srcHeigth = getHeight(image);
		if (srcWidth >= srcHeigth) {
			zoomSize[0] = width;//(heigth / srcHeigth ) * srcWidth;
			zoomSize[1] = (width / srcWidth ) * srcHeigth;
		}
		if (srcWidth <= srcHeigth) {
			zoomSize[0] = width;//(heigth / srcHeigth ) * srcWidth;
			zoomSize[1] = (width / srcWidth ) * srcHeigth;
		}
		return zoomSize;
	}
	
	public static void main(String[] args) throws IOException {
		ImageManager imageManager = new ImageManager();
		//imageManager.zoomImg(imageManager, "d:/(89).jpg", "d:/(8).jpg", 770, 350);
		imageManager.thumbnail(imageManager, "d:/(13).jpg", "d:/psb1.jpg", 200, 100000000);
	}
}