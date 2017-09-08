package com.zhiyou100.video.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.FrontResult;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MD5Utils;
import com.zhiyou100.video.utils.PictureUtil;

/**  
* @ClassName: FrontUserController  
* @Description: TODO
* @author lyb  
* @date 2017年8月29日  下午7:06:50
*  
*/
@Controller
@RequestMapping("/front/user")
public class FrontUserController {

	@Autowired
	private FrontUserService fus;
	
	
	/**  
	* @Title: registUser  
	* @Description: 注册
	* @param @param u
	* @param @return FrontResult
	* @throws  
	*/ 
	@RequestMapping("/regist.action")
	@ResponseBody
	public FrontResult registUser(User u) {
		FrontResult result = new FrontResult();
		u.setPassword(MD5Utils.getMD5(u.getPassword()));
		result.setSuccess(fus.registUser(u));
		if(!result.getSuccess()){
			result.setMessage("用户已存在");
		}
		return result;
	}
	/**  
	* @Title: loginUser  
	* @Description: 登录
	* @param @param u
	* @param @param session
	* @param @return FrontResult
	* @throws  
	*/ 
	@RequestMapping("/login.action")
	@ResponseBody
	public FrontResult loginUser(User u,HttpSession session) {
		FrontResult result = new FrontResult();
		u.setPassword(MD5Utils.getMD5(u.getPassword()));
		User user = fus.logintUser(u);
		result.setSuccess(user != null);
		if(user == null){
			result.setMessage("用户名密码不正确");
		}else{
			session.setAttribute("_front_user", user);
		}
		return result;
	}
	/**  
	* @Title: loginOut  
	* @Description: 退出
	* @param @param session
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping("/logout.action")
	public String loginOut(HttpSession session) {
		session.removeAttribute("_front_user");
		return "redirect:/index.action";
	}
	
	/**  
	* @Title: userIndex  
	* @Description: 个人信息界面
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping("/index.action")
	public String userIndex(HttpSession session,Model md) {
		/*md.addAttribute("user", getUser(session.getAttribute("_front_user")));*/
		resetSessionAndModelUser(session, md);
		return "front/user/index";
	}
	/**  
	* @Title: userProfile  
	* @Description: 跳转到修改个人信息页面
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/profile.action",method=RequestMethod.GET)
	public String userProfile(HttpSession session,Model md) {
		/*md.addAttribute("user", getUser(session.getAttribute("_front_user")));*/
		resetSessionAndModelUser(session, md);
		return "front/user/profile";
	}
	/**  
	* @Title: userProfileUpdate  
	* @Description: 修改个人信息
	* @param @param u
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/profile.action",method=RequestMethod.POST)
	public String userProfileUpdate(User u,HttpSession session) {
		u.setUpdateTime(new Date());
		fus.updateUser(u);
		return "redirect:/front/user/index.action";
	}
	
	/**  
	* @Title: userAvatar  
	* @Description: 跳转到更改头像
	* @param @param u
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/avatar.action",method=RequestMethod.GET)
	public String userAvatar(User u,HttpSession session,Model md) {
		/*md.addAttribute("user", getUser(session.getAttribute("_front_user")));*/
		resetSessionAndModelUser(session, md);
		return "front/user/avatar";
	}
	
	/**
	* @throws IOException 
	* @throws IllegalStateException   
	* @Title: userAvatarUpdate  
	* @Description: 上传头像信息
	* @param @param session
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/avatar.action",method=RequestMethod.POST)
	public String userAvatarUpdate(MultipartFile image_file,HttpSession session) throws Exception {
		//从Session域中取出_front_user
		User u = (User)session.getAttribute("_front_user");
		//拼接/pic/加新的文件名,并放入对象中
		u.setHeadUrl(PictureUtil.getPictureUrl(image_file.getOriginalFilename()));
		//将更新是将放入user对象中
		u.setUpdateTime(new Date());
		//文件的上传
		image_file.transferTo(PictureUtil.getPictureFile(u.getHeadUrl()));
		//更新user,向数据库更改文件名
		fus.updateUser(u);
		resetSessionAndModelUser(session, null);
		return "redirect:/front/user/index.action";
	}
	/**  
	* @Title: userPassword  
	* @Description: 跳转到重置密码界面
	* @param @param image_file
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/password.action",method=RequestMethod.GET)
	public String userPassword(HttpSession session,Model md) {
		resetSessionAndModelUser(session, md);
		return "front/user/password";
	}
	/**  
	* @Title: userPasswordUpdate  
	* @Description: 更新密码
	* @param @param session
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value="/password.action",method=RequestMethod.POST)
	public String userPasswordUpdate(HttpSession session,String oldPassword,String newPassword,Model md) {
		User u =(User) session.getAttribute("_front_user");
		if(!u.getPassword().equals(MD5Utils.getMD5(oldPassword))){
			md.addAttribute("message", "原始密码错误");
		}else{
			u.setPassword(MD5Utils.getMD5(newPassword));
			fus.updateUser(u);
			md.addAttribute("message", "修改成功");
		}
		resetSessionAndModelUser(session, md);
		return "front/user/password";
	}
	
	/**  
	* @Title: getUser  
	* @Description: 私有方法,通过域中user的id查找数据库中的user对象
	* @param @param obj
	* @param @return User
	* @throws  
	*/ 
/*	private User getUser(Object obj){
		User u = (User) obj;
		return fus.findUserBySessionUser(u);
	}
*/
	/**  
	* @Title: resetSessionAndModelUser  
	* @Description: 重置session中的_front_user和设置model中的user
	* @param @param session
	* @param @param md void
	* @throws  
	*/ 
	private void resetSessionAndModelUser(HttpSession session, Model md){
		User u = (User) session.getAttribute("_front_user");
		User newUser = fus.findUserBySessionUser(u);
		session.setAttribute("_front_user", newUser);
		if(md != null){
			md.addAttribute("user", newUser);
		}
	}
	
	
	
	
	
	
	
	
}
