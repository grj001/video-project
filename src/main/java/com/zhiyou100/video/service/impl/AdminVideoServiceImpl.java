package com.zhiyou100.video.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminVideoServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午6:18:06
*  
*/
@Service
public class AdminVideoServiceImpl implements AdminVideoService {

	@Autowired
	private VideoMapper vm;

	@Override
	public Page<Video> loadPage(String queryName, Integer speakerId, Integer courseId, Integer page) {
		Page<Video> thePage = new Page<>();
		thePage.setPage(page);
		thePage.setSize(5);
		thePage.setTotal(vm.findCount(queryName,speakerId,courseId));
		thePage.setRows(vm.findVideo(queryName,speakerId,courseId,(page-1)*5));		
		return thePage;
	}

	@Override
	public void batchDelete(Integer[] checkid) {
		
		VideoExample ve = new VideoExample();
		ve.createCriteria().andIdIn(Arrays.asList(checkid));
		vm.deleteByExample(ve);
	}

	@Override
	public void deleteVideoById(Integer id) {
		vm.deleteByPrimaryKey(id);
	}
	
}
