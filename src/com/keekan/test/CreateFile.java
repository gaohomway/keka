package com.keekan.test;

import java.io.File;

public class CreateFile {
	
	public static void main(String[] args) {
		File file = new File("D:\\kan\\C");
		  file.mkdirs();
		  
		  //file = new File("D:\\A\\B\\D");
		  //file.mkdir();
	}

}
