package com.project.apirestfullvoting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.apirestfullvoting.domain.Guideline;
import com.project.apirestfullvoting.domain.Session;
import com.project.apirestfullvoting.repository.GuidelineRepository;
import com.project.apirestfullvoting.repository.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private GuidelineRepository guidelineRepository;
		
	public List<Session> list(){
		return sessionRepository.findAll();
	}
	
	public Session create(Session s) {
		
		if(s.getStartTime() == null) {
			s.setStartTime(LocalDateTime.now());
		}
		if(s.getSessionMinutes() == null) {
			s.setSessionMinutes(1L);
		}
		Optional<Guideline> g = guidelineRepository.findById(s.getGuideline().getId());
		s.setGuideline(g.get());
		return sessionRepository.save(s);
	}
	
}
