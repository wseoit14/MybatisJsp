package com.example.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class TestExample {
	public static void main(String[] args) {
		String url = getProperty("url.b");
		download(url, "karina.mp4");
	}
	
	public static String getProperty(String name) {
		try(FileInputStream fis = new FileInputStream("src/main/resources/application.properties");){
			Properties prop = new Properties();
			prop.load(fis);
			String value = prop.getProperty(name);
			return Objects.isNull(value)?null:value;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void download(String url, String fileName) {
		File file = new File("src/main/resources/images");
		if(!file.exists())file.mkdirs();
		try(
				InputStream is = new URL(url).openStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = new FileOutputStream(new File(file.getAbsolutePath()+"/"+fileName));
				BufferedOutputStream bos = new BufferedOutputStream(os);
				){
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = bis.read(bytes))>-1) {
				bos.write(bytes, 0, read);
				bos.flush();
			}
			
			System.out.println("save done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
