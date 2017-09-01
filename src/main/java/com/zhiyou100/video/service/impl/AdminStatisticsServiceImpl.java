package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminStatisticsMapper;
import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.service.AdminStatisticsService;

/**  
* @ClassName: AdminStatisticsServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午8:41:53
*  
*/
@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService {

	@Autowired
	AdminStatisticsMapper asm;

	@Override
	public List<Statistics> findStatistics() {
		
		
		return asm.findStatistics();
	}
	
}
