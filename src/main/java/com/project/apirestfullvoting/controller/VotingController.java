package com.project.apirestfullvoting.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.domain.Vote;
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
	public Vote voting(@RequestBody Vote v) {
		return votingService.voting(v);
	}
}
