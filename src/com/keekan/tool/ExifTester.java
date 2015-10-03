package com.keekan.tool;

import java.io.File;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectory;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 读取照片Exif信息 <br>
 */
public class ExifTester {
	
	public static void main(String[] args) throws Exception {
		
		File jpegFile = new File("C:\\keekan\\photo\\album\\DSC02589.JPG");
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		Directory exif = metadata.getDirectory(ExifDirectory.class);
		
		Iterator tags = exif.getTagIterator();
		
		while (tags.hasNext()) {
			Tag tag = (Tag) tags.next();
			System.out.println(tag);
		}
	}
}
