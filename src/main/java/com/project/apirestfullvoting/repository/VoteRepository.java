package com.project.apirestfullvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apirestfullvoting.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
