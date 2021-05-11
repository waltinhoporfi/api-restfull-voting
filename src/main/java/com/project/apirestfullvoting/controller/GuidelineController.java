package com.project.apirestfullvoting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.model.Guideline;
import com.project.apirestfullvoting.service.GuidelineService;

@RestController
@RequestMapping("guidelines")
public class GuidelineController {

	private final GuidelineService guidelineService;
	
	public GuidelineController(GuidelineService guidelineService) {
		this.guidelineService = guidelineService;
	}
	
	@GetMapping
	public List<Guideline> list(){
		return guidelineService.list();		
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Guideline guideline) {	
		
		try {
			Guideline retorno = guidelineService.insert(guideline);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
