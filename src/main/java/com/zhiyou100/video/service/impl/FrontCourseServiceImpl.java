package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.FrontCourseService;

/**  
* @ClassName: FrontCourseServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午3:55:38
*  
*/
@Service
public class FrontCourseServiceImpl implements FrontCourseService {

	@Autowired
	private CourseMapper cm;
	@Autowired
	private SubjectMapper sjm;
	
	@Override
	public List<Course> findCourseBySubjectId(Integer subjectId) {
		return cm.findCourseBySubjectId(subjectId);
	}
	@Override
	public Subject findSubjectById(Integer subjectId) {
		return sjm.selectByPrimaryKey(subjectId);
	}
	@Override
	public Course findCourseWithVideosByCourseId(Integer courseId) {
		
		return cm.findCourseWithVideosByCourseId(courseId);
	}

	
}
