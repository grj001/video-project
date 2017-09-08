package com.zhiyou100.video.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.video.model.FrontResult;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MD5Utils;
import com.zhiyou100.video.utils.MailUtil;
import com.zhiyou100.video.utils.RandomUtil;

/**  
* @ClassName: FrontHomeController  
* @Description: TODO
* @author lyb  
* @date 2017年8月29日  下午7:02:26
*  
*/
@Controller
public class FrontHomeController {

	@Autowired
	private FrontUserService fus;
	/**  
	* @Title: indexPage  
	* @Description: 首页
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping("/index.action")
	public String indexPage(){
		return "front/index";
	}
	/**  
	* @Title: forgetPwd  
	* @Description: 忘记密码界面
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value = "/forgetpwd.action", method=RequestMethod.GET)
	public String forgetPwd(){
		return "front/user/forget_pwd";
	}
	/**  
	* @Title: sendMail  
	* @Description: 发送验证码
	* @param @param email
	* @param @return
	* @param @throws Exception FrontResult
	* @throws  
	*/ 
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public FrontResult sendMail(String email) throws Exception{
		FrontResult fr = new FrontResult();
		Boolean orExist = fus.checkMail(email);
		
		fr.setSuccess(orExist);
		if(!orExist){
			fr.setMessage("邮箱不存在,请核对");
		}else{
			Integer ran = RandomUtil.getRandomCode();
			fus.updateCode(email,ran);
			String content = "您好,您的验证码为"+ran;
			MailUtil.send(email, "验证信息", content);
		}
		return fr;
	}
	/**  
	* @Title: forgetPwdUpdate  
	* @Description: 验证随机码,如果成功跳转到重置密码界面
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value = "/forgetpwd.action", method=RequestMethod.POST)
	public String forgetPwdUpdate(String email,String captcha,Model md){
		User u = fus.checkCaptcha(email,captcha);
		if(u == null){
			md.addAttribute("message", "验证码不匹配");
			return "front/user/forget_pwd";
		}
		md.addAttribute("email", email);
		md.addAttribute("captcha", captcha);
		return "front/user/reset_pwd";
	}
	/**  
	* @Title: resetPwd  
	* @Description: 重置密码操作
	* @param @param email
	* @param @param captcha
	* @param @param md
	* @param @return String
	* @throws  
	*/ 
	@RequestMapping(value = "/resetpwd.action", method=RequestMethod.POST)
	public String resetPwd(User u,Model md,HttpSession session){
		u.setPassword(MD5Utils.getMD5(u.getPassword()));
		User sessionUser = fus.restPwd(u);
		session.setAttribute("_front_user", sessionUser);
		return "redirect:/index.action";
	}
	
	
	
}