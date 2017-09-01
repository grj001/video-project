package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.AdminExample;
import com.zhiyou100.video.service.AdminUserService;
/**  
* @ClassName: AdminUserServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:53:31
*    
*/ 
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminMapper am;

	@Override
	public List<Admin> findLoginUser(Admin admin) {
		
		AdminExample ae = new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(admin.getLoginName()).andLoginPwdEqualTo(admin.getLoginPwd());
		
		return am.selectByExample(ae);
	}
	
}
