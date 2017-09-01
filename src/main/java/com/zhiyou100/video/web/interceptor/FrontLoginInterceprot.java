package com.zhiyou100.video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.User;

/**  
* @ClassName: FrontLoginInterceprot  
* @Description: 前台拦截器
* @author lyb  
* @date 2017年8月31日  下午8:15:12
*  
*/
public class FrontLoginInterceprot implements HandlerInterceptor {

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
		Object frontUser  = req.getSession().getAttribute("_front_user");
		if(frontUser == null){
			res.sendRedirect(req.getContextPath()+"/index.action");
			return false;
		}
		return true;
	}

}
