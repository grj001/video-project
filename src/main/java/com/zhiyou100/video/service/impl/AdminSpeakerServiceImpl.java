package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerExample;
import com.zhiyou100.video.service.AdminSpeakerService;
import com.zhiyou100.video.utils.Page;

/**  
* @ClassName: AdminSpeakerServiceImpl  
* @Description: TODO
* @author lyb  
* @date 2017年8月27日  下午2:52:28
*  
*/
@Service
public class AdminSpeakerServiceImpl implements AdminSpeakerService {

	@Autowired
	private SpeakerMapper sm;

	@Override
	public Page<Speaker> loadPage(String queryName, String queryJob, Integer page) {
		
		SpeakerExample se = new SpeakerExample();
		se.createCriteria().andSpeakerNameLike("%"+queryName+"%").andSpeakerJobLike("%"+queryJob+"%");
		Page<Speaker> thePage = new Page<>();
		thePage.setPage(page);
		thePage.setSize(5);
		thePage.setTotal(sm.countByExample(se));
		thePage.setRows(sm.selectByPageInfo(queryName, queryJob, (page-1)*5));
		return thePage;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insertSelective(speaker);
	}
	@Override
	public Speaker findSpeakerById(Integer id) {
		
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeaker(Speaker sp) {
		sm.updateByPrimaryKeySelective(sp);
	}

	@Override
	public void deleteSpeakerById(Integer id) {
		sm.deleteByPrimaryKey(id);
	}

	@Override
	public List<Speaker> findAllSpeakers() {
		
		return sm.selectByExample(null);
	}
}
