package com.zhiyou100.video.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.FrontUserService;

/**  
* @ClassName: FrontUserServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月29日  下午7:26:10
*  
*/
@Service
public class FrontUserServiceImpl implements FrontUserService {

	@Autowired
	private UserMapper um;

	@Override
	public Boolean registUser(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		List<User> li = um.selectByExample(ue);
		if(!li.isEmpty()){
			return false;
		}
		
		
		u.setInsertTime(new Date(System.currentTimeMillis()));
		um.insertSelective(u);
		return true;
	}

	@Override
	public User logintUser(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		List<User> li = um.selectByExample(ue);
		if(!li.isEmpty()){
			return li.get(0);
		}
		return null;
	}

	@Override
	public User findUserBySessionUser(User u) {
		return um.selectByPrimaryKey(u.getId());
	}

	@Override
	public void updateUser(User u) {
		 um.updateByPrimaryKeySelective(u);
	}

	@Override
	public Boolean checkMail(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> li = um.selectByExample(ue);
		
		return !li.isEmpty();
	}

	@Override
	public void updateCode(String email, Integer ran) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		User u  = new User();
		u.setCaptcha(ran+"");
		um.updateByExampleSelective(u, ue);
	}

	@Override
	public User checkCaptcha(String email, String captcha) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email).andCaptchaEqualTo(captcha);
		List<User> li = um.selectByExample(ue);
		if(li.isEmpty()){
			return null;
		}
		return li.get(0);
	}

	@Override
	public User restPwd(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		um.updateByExampleSelective(u, ue);
		List<User> list = um.selectByExample(ue);
		return list.get(0);
	}

	
	
	
}
