package com.project.apirestfullvoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.repository.GuidelineRepository;

@Service
public class GuidelineService {
	
	@Autowired
	private GuidelineRepository guidelineRepository;
		
	public List<Guideline> list(){
		return guidelineRepository.findAll();		
	}
	
	public Guideline insert(Guideline guideline) {			
		return guidelineRepository.save(guideline);
	}
	
}
