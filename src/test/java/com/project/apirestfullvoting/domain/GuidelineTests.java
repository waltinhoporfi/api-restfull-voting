package com.project.apirestfullvoting.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apirestfullvoting.model.Guideline;

@SpringBootTest
public class GuidelineTests {

	@Test
	public void create() {
		Guideline g = new Guideline(null, "Primeira Pauta");
		
		System.out.println(g);
	}
	
}
