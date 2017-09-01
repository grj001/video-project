package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminCourseService;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminVideoController  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:54:25
*    
*/ 
@Controller
@RequestMapping("/admin/video")
public class AdminVideoController {

	@Autowired
	private AdminVideoService avs;
	@Autowired
	private AdminCourseService acs;
	@Autowired
	private AdminSpeakerService ass;
	
	@RequestMapping("/list.action")
	public String videoList(@RequestParam(defaultValue="")String queryName,
			@RequestParam(defaultValue="0")Integer speakerId,
			@RequestParam(defaultValue="0")Integer courseId,
			@RequestParam(defaultValue="1")Integer page,
			Model md){		
		
		
		List<Speaker> speakers = ass.findAllSpeakers();
		List<Course> courses = acs.findAllCourses();
		md.addAttribute("speakers", speakers);
		md.addAttribute("courses", courses);
		
		
		
		md.addAttribute("queryName", queryName);
		md.addAttribute("speakerId", speakerId);
		md.addAttribute("courseId", courseId);
		
		
		
	    Page<Video> thePage = avs.loadPage(queryName,speakerId,courseId,page);
	    md.addAttribute("page", thePage);
		return "admin/video/list";
	}
	
	
	
	@RequestMapping("/batchDelete.action")
	public String videoBatchDelete(Integer[]checkid){	
		
		avs.batchDelete(checkid);
		return "redirect:/admin/video/list.action";
	}
	
	
	
	
	
	
	
	@RequestMapping("/delete.action")
	@ResponseBody
	public String videoDelete(Integer id){		
		
		avs.deleteVideoById(id);
		
		return "success";
	}	
}
