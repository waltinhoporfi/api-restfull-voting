package com.project.apirestfullvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apirestfullvoting.domain.Associated;

public interface AssociatedRepository extends JpaRepository<Associated, Long> {

}
