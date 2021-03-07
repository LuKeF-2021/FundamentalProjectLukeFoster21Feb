package com.qa.fundamentalProject.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Champion {
	

	// variables
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long champID;
	

	private String champName;
	
	
	private int champCost;
	
	
	private String champClass;
	
	
	private String champRoles;
	
	
    private String champReleaseYear;
	
	
	private String champOwned;
	
	
	private String champOnSale;


	
	
	
	
}
