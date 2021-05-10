package com.project.apirestfullvoting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.domain.Associated;
import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.domain.Vote;
import com.project.apirestfullvoting.repository.AssociatedRepository;
import com.project.apirestfullvoting.repository.GuidelineRepository;
import com.project.apirestfullvoting.repository.VoteRepository;

@RestController
@RequestMapping("voting")
public class VotingController {
	
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private AssociatedRepository associatedRepository;
	@Autowired
	private GuidelineRepository guidelineRepository;
	
	@RequestMapping("welcome")
	public String votingMsg() {
		return "Bem vindo a votação da assembleia";
	}
	
	@GetMapping
	public List<Vote> voting() { //guideline, associated, choice
		return voteRepository.findAll();
	}
	
	@PostMapping("insert")
	public Vote voting(@RequestBody Vote v) { //guideline, associated, choice
		
		Optional<Associated> a = associatedRepository.findById(v.getAssociated().getId());
		Optional<Guideline> g = guidelineRepository.findById(v.getGuideline().getId());
		
		v.setAssociated(a.get());
		v.setGuideline(g.get());
		
		return voteRepository.save(v);
	}
}
