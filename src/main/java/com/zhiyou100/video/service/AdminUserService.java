package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Admin;

/**  
* @ClassName: AdminUserService  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:53:24
*    
*/ 
public interface AdminUserService {

	List<Admin> findLoginUser(Admin admin);

}
