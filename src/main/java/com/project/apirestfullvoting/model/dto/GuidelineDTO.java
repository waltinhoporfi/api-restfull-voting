package com.project.apirestfullvoting.model.dto;

import com.project.apirestfullvoting.model.Guideline;

public class GuidelineDTO {

	private Guideline guideline;
	
	private Long sumVotes;
	
	private Boolean result;

	public Guideline getGuideline() {
		return guideline;
	}

	public void setGuideline(Guideline guideline) {
		this.guideline = guideline;
	}

	public Long getSumVotes() {
		return sumVotes;
	}

	public void setSumVotes(Long sumVotes) {
		this.sumVotes = sumVotes;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
	
	
	
}
