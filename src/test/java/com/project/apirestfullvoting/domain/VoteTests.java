package com.project.apirestfullvoting.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apirestfullvoting.model.Associated;
import com.project.apirestfullvoting.model.Guideline;
import com.project.apirestfullvoting.model.Vote;

@SpringBootTest
public class VoteTests {
	
	@Test
	public void create() {
		Guideline pauta = new Guideline();
		Associated a = new Associated(null, "11215131402", "Walter Porfirio Silveira");
		Vote v = new Vote(null, pauta, a, true);
		
		System.out.println(v);
	}
		
}
