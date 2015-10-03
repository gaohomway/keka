package com.keekan.tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;

public class ImageZoom {

	public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
		
		int type = source.getType();		// targetW，targetH分别表示目标长和宽
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		
		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else{
			target = new BufferedImage(targetW, targetH, type);
		}
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		// g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//没有上一个效果好

		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}
	
	public static boolean resizePicture(String rawName, String shrinkName, int limitWidth, int limitHeight) throws Exception {
		File file = new File(rawName);
		BufferedImage bImage = ImageIO.read(file);
		int width = bImage.getWidth(); 		// 源图宽度
		int height = bImage.getHeight(); 	// 源图高度          
		if (width > limitWidth || height > limitHeight) {
			String imgType = "JPEG";
			if (rawName.toLowerCase().endsWith(".png")) {
				imgType = "png";
			}
			File saveFile = new File(shrinkName);
			if (limitWidth > 0 || limitHeight > 0) {
				bImage = resize(bImage, limitWidth, limitHeight);
			}
			ImageIO.write(bImage, imgType, saveFile);
			return true;
		}else {
			return false;
		}
	}

	public static void main(String argv[]) {
		try {
			ImageZoom.resizePicture("c:/11.jpg", "d:/11.jpg", 770, 350);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}