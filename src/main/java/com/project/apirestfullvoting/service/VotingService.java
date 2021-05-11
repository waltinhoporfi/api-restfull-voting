package com.project.apirestfullvoting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apirestfullvoting.exception.VoteException;
import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.model.Guideline;
import com.project.apirestfullvoting.model.Vote;
import com.project.apirestfullvoting.model.dto.GuidelineDTO;
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
	
	public Vote voting(Vote vote) {				
		
		validateVote(vote);
		
		Optional<Associated> associated = associatedRepository.findById(vote.getAssociated().getId());		
		Optional<Guideline> guideline = guidelineRepository.findById(vote.getGuideline().getId());
		
		if(associated.isPresent()) {			
			vote.setAssociated(associated.get());
		}else {
			throw new VoteException("O associado informado não existe");
		}
		if(guideline.isPresent()) {			
			vote.setGuideline(guideline.get());
		}else {
			throw new VoteException("A pauta informada não existe");
		}		
		
		return voteRepository.save(vote);
	}
	
	public void validateVote(Vote vote) {
		if(vote.getGuideline() == null || vote.getGuideline().getId() == null) {
			throw new VoteException("A pauta é obrigatória para votação");
		}
		if(vote.getAssociated() == null || vote.getAssociated().getId() == null) {
			throw new VoteException("O associado é obrigatório para votação");
		}
		if(vote.getChoice() == null) {
			throw new VoteException("A escolha é obrigatória para votação");
		}
		if(voteRepository.existsByGuidelineIdAndAssociatedId(vote.getGuideline().getId(), vote.getAssociated().getId())) {
			throw new VoteException("Você já votou nesta pauta");
		}
	}
	
	public GuidelineDTO sumVotes(Long guidelineId) {
		
		List<Vote> votes = voteRepository.findByGuidelineId(guidelineId);
		Long sumYes = 0L;
		Long sumNo = 0L;
		for(Vote vote: votes) {
			if(vote.getChoice()) {
				sumYes++;
			}else {
				sumNo++;
			}			
		}
		GuidelineDTO guidelineDTO = new GuidelineDTO();
		guidelineDTO.setSumVotes(sumYes+sumNo);
		if(sumYes > sumNo) {
			guidelineDTO.setResult(true);
		}else if(sumYes < sumNo) {
			guidelineDTO.setResult(false);
		}
		if(!votes.isEmpty()) {
			guidelineDTO.setGuideline(votes.get(0).getGuideline());
		}
		return guidelineDTO;
	}

}
