package com.project.apirestfullvoting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.model.Guideline;
import com.project.apirestfullvoting.model.Vote;

@SpringBootTest
public class VoteRepositoryTests {

	@Autowired
	private VoteRepository voteRepository;
	
	@Test
	public void insert() {
		Associated a = new Associated(null, "11215131402", "Walter Porfirio Silveira");
		Guideline p = new Guideline(null, "Pauta piscina");
		Vote v1 = new Vote(null, p, a, true);
	
		voteRepository.save(v1);
	}
	
}
