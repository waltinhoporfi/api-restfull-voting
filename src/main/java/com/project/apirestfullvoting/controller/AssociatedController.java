package com.project.apirestfullvoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.domain.Associated;
import com.project.apirestfullvoting.repository.AssociatedRepository;

@RestController
@RequestMapping("associated")
public class AssociatedController {

	@Autowired
	private AssociatedRepository associatedRepository;
	
	@GetMapping
	public List<Associated> list() {
		return associatedRepository.findAll();
	}
	
	@PostMapping("insert")
	public Associated insert(@RequestBody Associated a) {
		return associatedRepository.save(a);
	}
	
}
