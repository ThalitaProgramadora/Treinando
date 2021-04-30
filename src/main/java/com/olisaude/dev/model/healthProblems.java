package com.olisaude.dev.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="healthProblems")
public class healthProblems {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private @Id long id;
	 private @NotNull @Size(min = 3, max =50, message = "Error Size")String name;
	 private @NotNull int degreeProblem;
	 private @NotNull double score;
	 @ManyToOne
	 @JsonIgnoreProperties("healthProblems")
	 private Client client;
	 
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDegreeProblem() {
		return degreeProblem;
	}
	public void setDegreeProblem(int degreeProblem) {
		this.degreeProblem = degreeProblem;
	}
	 
	 
}
