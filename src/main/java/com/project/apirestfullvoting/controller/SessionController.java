package com.project.apirestfullvoting.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apirestfullvoting.model.Session;
import com.project.apirestfullvoting.service.SessionService;

@RestController
@RequestMapping("sessions")
public class SessionController {

	private final SessionService sessionService;
	
	public SessionController(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	@GetMapping
	public List<Session> list(){
		return sessionService.list();
	}
	
	@PostMapping
	public Session create(@RequestBody Session s) {
		return sessionService.create(s);		
	}
	
}
