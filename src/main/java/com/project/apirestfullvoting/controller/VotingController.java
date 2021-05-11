package com.project.apirestfullvoting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.model.Vote;
import com.project.apirestfullvoting.model.dto.GuidelineDTO;
import com.project.apirestfullvoting.service.VotingService;

@RestController
@RequestMapping("voting")
public class VotingController {
	
	private final VotingService votingService;
	
	public VotingController(VotingService votingService) {
		this.votingService = votingService;
	}
	
	@RequestMapping("welcome")
	public String votingMsg() {
		return votingService.votingMsg();
	}
	
	@GetMapping
	public List<Vote> voting() {
		return votingService.voting();
	}
	
	@PostMapping
	public ResponseEntity<Object> voting(@RequestBody Vote v) {	
		try {
			Vote retorno = votingService.voting(v);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@GetMapping("sumVoting")
	public GuidelineDTO sumVoting(@RequestParam Long guidelineId) {
		return votingService.sumVotes(guidelineId);
	}
	
}
