package com.project.apirestfullvoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.repository.GuidelineRepository;

@RestController
@RequestMapping("guidelines")
public class GuidelineController {

	@Autowired
	private GuidelineRepository guidelineRepository;
	
	@GetMapping
	public List<Guideline> list(){
		return guidelineRepository.findAll();		
	}
	
	@PostMapping("insert")
	public Guideline insert(@RequestBody Guideline guideline) {			
		return guidelineRepository.save(guideline);
	}
	
}
