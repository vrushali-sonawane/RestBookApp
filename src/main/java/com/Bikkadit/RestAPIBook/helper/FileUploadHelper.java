package com.Bikkadit.RestAPIBook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR="E:\\Workspaces\\SpringBootPracticeD\\RestAPIBook\\src\\main\\resources\\static\\image";

	//to get file path dynamically
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
  // to handle Io Exception
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	public boolean uploadFile(MultipartFile multipartfile) {
		
		boolean f=false;
		
		try {
			//with old API
			//read data from given file
//			InputStream is = multipartfile.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
			
			//write data to upload directory
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			   
			//using new API
			//path of uploading file
			Files.copy(multipartfile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

}
