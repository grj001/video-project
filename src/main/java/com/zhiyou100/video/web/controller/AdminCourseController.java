package com.zhiyou100.video.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.service.AdminCourseService;

/**  
* @ClassName: AdminCourseController  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:54:16
*    
*/ 
@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {

	@SuppressWarnings("unused")
	@Autowired
	private AdminCourseService acs;

	
}
