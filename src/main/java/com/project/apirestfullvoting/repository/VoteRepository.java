package com.project.apirestfullvoting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.apirestfullvoting.model.Vote;

@Component
public interface VoteRepository extends JpaRepository<Vote, Long> {	

	public Boolean existsByGuidelineIdAndAssociatedId(Long guidelineId, Long associatedId);
	
	public List<Vote> findByGuidelineId(Long guidelineId);
}
