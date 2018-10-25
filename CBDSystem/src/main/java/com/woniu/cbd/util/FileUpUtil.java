package com.woniu.cbd.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;


public class FileUpUtil {
	public static  List<String> fileUpUtil(MultipartFile[] files,HttpServletRequest request,String path) {
		// 创建文件路径
		String basePath = request.getSession().getServletContext().getRealPath(path);
		File f = new File(basePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		List<String> temp=new ArrayList<String>();
		// 循环获得文件
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			// 循环获取上传文件的文件名
			String fileName = file.getOriginalFilename();
			
			temp.add("/CBDSystem"+path+"/"+fileName);
			// 目标文件
			File targetFile = new File(basePath, fileName);
			// 转存文件
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
}

