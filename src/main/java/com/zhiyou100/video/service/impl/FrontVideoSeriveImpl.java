package com.zhiyou100.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontVideoSerive;

/**  
* @ClassName: FrontVideoSeriveImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午5:47:18
*  
*/
@Service
public class FrontVideoSeriveImpl implements FrontVideoSerive {

	@Autowired
	private VideoMapper vm;

	@Override
	public void updateVideoPlayTimes(Integer videoId) {
		Video v = vm.selectByPrimaryKey(videoId);
		v.setVideoPlayTimes(v.getVideoPlayTimes() + 1);
		vm.updateByPrimaryKeySelective(v);
		
	}

	@Override
	public Video findVideoById(Integer videoId) {
		
		return vm.findeVideoWithCouserWithSpeakerByVideoId(videoId);
	}
	
	
	
	
}
