package com.olisaude.dev.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clients")
public class Client {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private @Id long id;
	 private @NotNull @Size(min = 3, max =50, message = "Error Size")String name;
	 private @NotNull String birthDate;
	 private @NotNull String gender;
	 private @NotNull @Size(min = 3, max =50, message = "Error Size")String healthProblem;
	 private @Temporal(TemporalType.TIMESTAMP) Date updateDate = new java.sql.Date(System.currentTimeMillis());
	 private @NotNull @Temporal(TemporalType.TIMESTAMP) Date creationDate = updateDate;
	 @OneToMany(mappedBy ="client", cascade= CascadeType.ALL)
	 @JsonIgnoreProperties("client")
	 private List<healthProblems> healthProblems;
	 
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHealthProblem() {
		return healthProblem;
	}
	public void setHealthProblem(String healthProblem) {
		this.healthProblem = healthProblem;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	 
	  
}
