package com.zhiyou100.video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.User;

/**  
* @ClassName: AdminLgoinIntercepror  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午8:14:32
*  
*/
public class AdminLgoinIntercepror implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		Object adm  = req.getSession().getAttribute("user");
		if(adm == null){
			res.sendRedirect(req.getContextPath()+"/admin/user/login.action");
			return false;
		}
		return true;
	}

}
