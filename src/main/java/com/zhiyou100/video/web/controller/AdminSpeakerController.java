package com.zhiyou100.video.web.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminSpeakerController  
* @Description: 主讲人管理
* @author lyb  
* @date 2017年8月27日  下午2:51:00
*  
*/
@Controller
@RequestMapping("/admin/speaker")
public class AdminSpeakerController {

	@Autowired
	private AdminSpeakerService ass;
	
	/**  
	* @Title: speakerList  
	* @Description: 主讲人列表,加载分页内容
	* @param @param queryName
	* @param @param queryJob
	* @param @param page
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping("/list.action")
	public String speakerList(@RequestParam(defaultValue="")String queryName,
			@RequestParam(defaultValue="")String queryJob,
			@RequestParam(defaultValue="1")Integer page,
			Model md){
		md.addAttribute("queryName", queryName);
		md.addAttribute("queryJob", queryJob);
		Page<Speaker> thePage = ass.loadPage(queryName,queryJob,page);
		md.addAttribute("page", thePage);
		return "admin/speaker/list";
	}
	
	@RequestMapping(value="/add.action",method=RequestMethod.GET)
	public String speakerAdd(){
		return "admin/speaker/add";
	}
	
	@RequestMapping(value="/add.action",method=RequestMethod.POST)
	public String speakerAddCommit(Speaker speaker){
		speaker.setInsertTime(new Date(System.currentTimeMillis()));
		speaker.setUpdateTime(new Date(System.currentTimeMillis()));
		ass.addSpeaker(speaker);
		return "redirect:/admin/speaker/list.action";
	}
	
	@RequestMapping(value="/update.action",method=RequestMethod.GET)
	public String speakerUpdate(Model md,Integer id){
		Speaker speaker = ass.findSpeakerById(id);
		md.addAttribute("sp", speaker);
		return "admin/speaker/update";
	}
	@RequestMapping(value="/update.action",method=RequestMethod.POST)
	public String speakerUpdate(Speaker sp){
		
		System.out.println(sp);
		
		ass.updateSpeaker(sp);
		
		return "redirect:/admin/speaker/list.action";
	}
	@RequestMapping(value="/delete.action")
	public String speakerDelete(Integer id){
		
		ass.deleteSpeakerById(id);
		
		return "redirect:/admin/speaker/list.action";
	}
	
	
	
	
}
