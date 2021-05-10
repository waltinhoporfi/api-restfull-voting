package com.project.apirestfullvoting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.apirestfullvoting.domain.Associated;
import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.domain.Vote;
import com.project.apirestfullvoting.repository.AssociatedRepository;
import com.project.apirestfullvoting.repository.GuidelineRepository;
import com.project.apirestfullvoting.repository.VoteRepository;

@Service
public class VotingService {

	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private AssociatedRepository associatedRepository;
	@Autowired
	private GuidelineRepository guidelineRepository;
	
	public String votingMsg() {
		return "Bem vindo a votação da assembleia";
	}
	
	public List<Vote> voting() {
		return voteRepository.findAll();
	}
	
	public Vote voting(Vote v) {
		
		Optional<Associated> a = associatedRepository.findById(v.getAssociated().getId());
		Optional<Guideline> g = guidelineRepository.findById(v.getGuideline().getId());
		
		v.setAssociated(a.get());
		v.setGuideline(g.get());
		
		return voteRepository.save(v);
	}
	
}
