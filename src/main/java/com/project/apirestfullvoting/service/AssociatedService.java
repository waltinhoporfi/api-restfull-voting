package com.project.apirestfullvoting.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.repository.AssociatedRepository;

@Service
public class AssociatedService {
	
	@Autowired
	private AssociatedRepository associatedRepository;
	
	public List<Associated> list() {
		return associatedRepository.findAll();
	}
	
	public Associated insert(@Valid Associated a) {
		return associatedRepository.save(a);
	}
}
