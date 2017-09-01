package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminSpeakerService  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:51:46
*  
*/
public interface AdminSpeakerService {

	Page<Speaker> loadPage(String queryName, String queryJob, Integer page);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(Integer id);

	void updateSpeaker(Speaker sp);

	void deleteSpeakerById(Integer id);

	List<Speaker> findAllSpeakers();



}
