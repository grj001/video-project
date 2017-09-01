package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;

/**  
* @ClassName: AdminCourseService  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午6:15:16
*  
*/
public interface AdminCourseService {

	List<Course> findAllCourses();

}
