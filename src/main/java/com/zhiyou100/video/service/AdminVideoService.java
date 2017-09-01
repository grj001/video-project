package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminVideoService  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午6:17:41
*  
*/
public interface AdminVideoService {

	Page<Video> loadPage(String queryName, Integer speakerId, Integer courseId, Integer page);

	void batchDelete(Integer[] checkid);

	void deleteVideoById(Integer id);

}
