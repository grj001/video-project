package com.zhiyou100.video.web.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.FrontCourseService;

/**  
* @ClassName: FrontCourseController  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午3:54:31
*  
*/
@Controller
@RequestMapping("/front/course")
public class FrontCourseController {

	@Autowired
	private FrontCourseService fcs;
	
	@RequestMapping(value = "/index.action")
	public String courseIndex(Integer subjectId,Model md){
	  Subject sj = fcs.findSubjectById(subjectId);
	  List<Course> list = fcs.findCourseBySubjectId(subjectId);
	  md.addAttribute("courses", list);
	  md.addAttribute("subjectId",subjectId);
	  md.addAttribute("subject", sj);
	  return "front/course/index";
	}
}
