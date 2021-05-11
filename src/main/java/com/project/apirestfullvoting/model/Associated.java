package com.project.apirestfullvoting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Associated {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 11)
	@NotEmpty(message = "The CPF cannot be empty")
	@NotNull(message = "The CPF cannot be null")
	private String cpf;
	
	@Column(length = 100)
	@NotEmpty(message = "The name cannot be empty")
	@NotNull(message = "The name cannot be null")
	private String name;
	
}
