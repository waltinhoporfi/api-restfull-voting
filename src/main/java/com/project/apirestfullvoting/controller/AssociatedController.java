package com.project.apirestfullvoting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.service.AssociatedService;

@RestController
@RequestMapping("associated")
public class AssociatedController {

	private final AssociatedService associatedService;
	
	public AssociatedController(AssociatedService associatedService) {
		this.associatedService = associatedService;
	}
	
	@GetMapping
	public List<Associated> list() {
		return associatedService.list();
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Associated associated) {
		
		try {			 
			Associated retorno = associatedService.insert(associated);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
	}
	
}