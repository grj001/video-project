package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Video;

/**  
* @ClassName: FrontVideoSerive  
* @Description: TODO
* @author lyb  
* @date 2017年8月31日  下午5:46:58
*  
*/
public interface FrontVideoSerive {

	void updateVideoPlayTimes(Integer videoId);

	Video findVideoById(Integer videoId);

}
