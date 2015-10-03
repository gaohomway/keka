package com.keekan.tool;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public final class Configurats {
	
	private static final String CONFIG_FILE_PATH = "/filePath.properties";
	
	/**
	 * 获得上传图片路径
	 * @param keys
	 * @return
	 * @throws IOException
	 */
	public static String getFilePath(String keys) throws IOException{
		Properties prop = new Properties();
		InputStream in = Configurats.class.getResourceAsStream(CONFIG_FILE_PATH);
		prop.load(in);
		return prop.getProperty(keys);
	}

	 /**  
     * 私有构造方法，不需要创建对象  
     */   
    private Configurats() {   
    }   
	
	public static void main(String args[]) throws IOException {
		String content = getFilePath("KEE_NUMBER_FILE_PATH");
		System.err.println(content);
	}
}