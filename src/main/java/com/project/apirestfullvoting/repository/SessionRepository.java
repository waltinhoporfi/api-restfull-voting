package com.project.apirestfullvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apirestfullvoting.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
