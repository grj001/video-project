package com.zhiyou100.video.mapper;

import java.util.List;

import com.zhiyou100.video.model.Statistics;

/**  
* @ClassName: AdminStatisticsMapper  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午8:43:24
*  
*/
public interface AdminStatisticsMapper {

	List<Statistics> findStatistics();
	
}
