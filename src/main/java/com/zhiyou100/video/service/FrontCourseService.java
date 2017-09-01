package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;

/**  
* @ClassName: FrontCourseService  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午3:55:07
*  
*/
public interface FrontCourseService {

	List<Course> findCourseBySubjectId(Integer subjectId);

	Subject findSubjectById(Integer subjectId);

	Course findCourseWithVideosByCourseId(Integer courseId);

}
