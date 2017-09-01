package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminCourseService;

/**  
* @ClassName: AdminCourseServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午6:15:55
*  
*/
@Service
public class AdminCourseServiceImpl implements AdminCourseService{

	@Autowired
	private CourseMapper cm;

	@Override
	public List<Course> findAllCourses() {
		return cm.selectByExample(null);
	}
	
	
	
}
