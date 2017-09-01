package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.service.FrontVideoSerive;

/**  
* @ClassName: FrontVideoController  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午5:46:23
*  
*/
@Controller
@RequestMapping("/front/video")
public class FrontVideoController {

	@Autowired
	private FrontCourseService fcs;
	@Autowired
	private FrontVideoSerive fvs;
	
	
	
	@RequestMapping("/index.action")
	public String videoIndex(Integer videoId, Integer subjectId,Model md){
		Subject sj = fcs.findSubjectById(subjectId);
		md.addAttribute("videoId", videoId);
		md.addAttribute("subject", sj);
		return "front/video/index";
	}
	
	@RequestMapping("/state.action")
	public void videoState(Integer videoId){
		fvs.updateVideoPlayTimes(videoId);
	}
	
	
	@RequestMapping("/videoData.action")
	public String videoData(Integer videoId,Model md){
		
		Video video = fvs.findVideoById(videoId);
		md.addAttribute("video", video);
		
		Course cou = fcs.findCourseWithVideosByCourseId(video.getCourseId());
		md.addAttribute("videoList", cou.getVideoList());
		
		
		md.addAttribute("subjectId", cou.getSubjectId());
		
		return "front/video/content";
	}
	
	
	
	
	
	
	
	
}
