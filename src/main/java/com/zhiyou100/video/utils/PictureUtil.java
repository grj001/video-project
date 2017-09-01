package com.zhiyou100.video.utils;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

/**  
* @ClassName: PictureUtil  
* @Description: 图片上传工具类
* @author lyb  
* @date 2017年8月31日  上午10:59:48
*  
*/
public class PictureUtil {
	/**  
	* @Fields field:field:{图片存取的根路径}
	*/ 
	private static final String BASE_PICTURE_FILE_PATH = "D:\\upload";
	/**  
	* @Fields field:field:{浏览器中获取图片的根路径}
	*/ 
	private static final String BASE_PICTURE_URL_PATH = "/pic/";
	
	/**  
	* @Title: getPictureName  
	* @Description: 通过原始名称生成图片名称
	* @param @param originalFilename
	* @param @return String
	* @throws  
	*/ 
	private static String getPictureName(String originalFilename){
		 String str = UUID.randomUUID().toString().replaceAll("-", "");
		 String ext = FilenameUtils.getExtension(originalFilename);
		 String fileName = str+"."+ext;
		 return fileName;
	}
	/**  
	* @Title: getPictureFile  
	* @Description: 通过原始名称生成文件路径
	* @param @param originalFilename
	* @param @return File
	* @throws  
	*/ 
	public static File getPictureFile(String pictureUrl){
		String [] st = pictureUrl.split("/");
		return new File(BASE_PICTURE_FILE_PATH+"\\"+st[2]);	 
	}
	/**  
	* @Title: getPictureUrl  
	* @Description: 通过原始名称生成url路径
	* @param @param originalFilename
	* @param @return String
	* @throws  
	*/ 
	public static String getPictureUrl(String originalFilename){
		return BASE_PICTURE_URL_PATH+getPictureName(originalFilename);
	}
}
