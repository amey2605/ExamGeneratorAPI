package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="question16june")
public @Data class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qtitle;
	private String qcategory;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	private String qanswer;
	private String difficulty;
	
	
}
