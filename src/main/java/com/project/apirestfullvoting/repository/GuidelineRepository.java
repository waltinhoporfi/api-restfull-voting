package com.project.apirestfullvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apirestfullvoting.model.Guideline;

public interface GuidelineRepository extends JpaRepository<Guideline, Long> {

}
