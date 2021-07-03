package com.petpet.customEL;

import java.io.*;
import java.util.Base64;

public class ImgOut {
	
	public static String ImgWrite(byte[] blob) {
		try {
		ByteArrayInputStream in = new ByteArrayInputStream(blob) ;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int length;
		while((length = in.read(buf))!=-1) {
			out.write(buf,0,length);
		}
		byte[] imageBytes = out.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		in.close();
		out.close();
		return base64Image;
		}catch(IOException e) {
			e.printStackTrace();
			return "";
		}				
	}
}
