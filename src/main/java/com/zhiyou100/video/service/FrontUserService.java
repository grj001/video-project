package com.zhiyou100.video.service;

import com.zhiyou100.video.model.User;

/**  
* @ClassName: FrontUserService  
* @Description: TODO
* @author lyb  
* @date 2017年8月29日  下午7:25:48
*  
*/
public interface FrontUserService {

	Boolean registUser(User u);

	User logintUser(User u);

	User findUserBySessionUser(User u);

	void updateUser(User u);

	Boolean checkMail(String email);

	void updateCode(String email, Integer ran);

	User checkCaptcha(String email, String captcha);

	User restPwd(User u);
}
