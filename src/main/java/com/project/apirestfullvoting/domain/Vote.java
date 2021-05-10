package com.project.apirestfullvoting.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Guideline guideline;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Associated associated;
	
	@Column(nullable = false)
	private Boolean choice;
	
	
}
