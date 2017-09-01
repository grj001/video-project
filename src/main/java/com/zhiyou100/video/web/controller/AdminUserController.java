package com.zhiyou100.video.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminUserService;

/**  
* @ClassName: AdminUserController  
* @Description: 处理后台用的登录和登出
* @author lyb  
* @date 2017年8月27日  下午2:24:01
*    
*/ 
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	@Autowired
	private AdminUserService aus;
	
	
	/**  
	* @Title: userLogin  
	* @Description: 跳转登录界面
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String userLogin(){
		return "admin/login";
	}
	
	/**  
	* @Title: commitLogin  
	* @Description: 判断登录成功还是失败
	* @param @param admin
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String commitLogin(Admin admin,Model md,HttpSession session){
		
		List<Admin>  list = aus.findLoginUser(admin);
		if(list.isEmpty()){
			md.addAttribute("message", "用户名密码不匹配");
			return "admin/login";
		}
		session.setAttribute("user", list.get(0));
		return "redirect:/admin/speaker/list.action";
	}
	@RequestMapping(value="/logout.action")
	public String userLogout(HttpSession session){
		session.removeAttribute("user");
		return "admin/login";
	}
}
