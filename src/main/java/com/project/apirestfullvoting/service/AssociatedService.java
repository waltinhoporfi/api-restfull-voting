package com.project.apirestfullvoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apirestfullvoting.exception.AssociatedException;
import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.repository.AssociatedRepository;

@Service
public class AssociatedService {
	
	@Autowired
	private AssociatedRepository associatedRepository;
	
	public List<Associated> list() {
		return associatedRepository.findAll();
	}
	
	public Associated insert(Associated associated) {
		
		validateAssociated(associated);
		
		return associatedRepository.save(associated);
	}
	
	public void validateAssociated(Associated associated) {				
		
		if(associated.getCpf() == null || associated.getCpf().isEmpty() ) {
			throw new AssociatedException("O campo CPF é obrigatório");
		}
		if(associated.getName() == null || associated.getName().isEmpty() ) {
			throw new AssociatedException("O campo nome é obrigatório");
		}
	}
	
}
