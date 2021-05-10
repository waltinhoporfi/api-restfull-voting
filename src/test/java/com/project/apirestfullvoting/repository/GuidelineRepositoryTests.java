package com.project.apirestfullvoting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.domain.Vote;

@SpringBootTest
public class GuidelineRepositoryTests {
	
	@Autowired
	private GuidelineRepository guidelineRepository;

	@Test
	public void insert() {
		Guideline pauta = new Guideline(null, "Primeira Pauta");
		
		guidelineRepository.save(pauta);
	}
	
}
