package com.project.apirestfullvoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apirestfullvoting.exception.GuidelineException;
import com.project.apirestfullvoting.model.Guideline;
import com.project.apirestfullvoting.repository.GuidelineRepository;

@Service
public class GuidelineService {
	
	@Autowired
	private GuidelineRepository guidelineRepository;
		
	public List<Guideline> list(){
		return guidelineRepository.findAll();		
	}
	
	public Guideline insert(Guideline guideline) {
		validateGuideline(guideline);
		return guidelineRepository.save(guideline);
	}
	
	public void validateGuideline(Guideline guideline) {
		if(guideline.getGuideline() == "" || guideline.getGuideline() == null ) {
			throw new GuidelineException("O campo pauta deve ser preenchido");
		}
	}

}
