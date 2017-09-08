package com.zhiyou100.video.utils;

import java.util.Random;

/**  
* @ClassName: RandomUtil  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午2:49:32
*  
*/
public class RandomUtil {
	
	private static final Integer LENGTH_NUM = 3;

	public static Integer getRandomCode(){
		Integer minNum = (int) Math.pow(10, (LENGTH_NUM-1));
		Integer maxNum = (int) Math.pow(10, LENGTH_NUM) - 1;
		Random ran  = new Random();
		return ran.nextInt((maxNum - minNum + 1 ) + minNum) ;
	}
	
}
