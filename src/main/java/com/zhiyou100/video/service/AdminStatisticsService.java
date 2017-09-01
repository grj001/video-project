package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Statistics;

/**  
* @ClassName: AdminStatisticsService  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午8:40:49
*  
*/
public interface AdminStatisticsService {

	List<Statistics> findStatistics();

}
