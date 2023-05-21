package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salles")
public class Salle {

	@Id
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;


	
	@ManyToOne
	@JoinColumn(name = "surveillant_id")
	private Surveillant surveillant;



	@OneToMany(mappedBy = "salle")
	private List<Tab> tables;


	
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	public Salle(String name, Surveillant surveillant) {
		this.name = name;
		this.surveillant = surveillant;
	}

	public Salle(String code,String name, Exam exam) {
		this.code  = code;
		this.surveillant = null;
		this.tables = null;
		this.name = name;
		this.exam = exam;
	}

	public Salle() {
		super();
	}

	public String getNname() {
		return name;
	}

	public void setNname(String name) {
		this.name = name;
	}

	public Surveillant getSurveillant() {
		return surveillant;
	}

	public void setSurveillant(Surveillant surveillant) {
		this.surveillant = surveillant;
	}

	public List<Tab> getTables() {
		return tables;
	}

	public void setTables(List<Tab> tables) {
		this.tables = tables;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
