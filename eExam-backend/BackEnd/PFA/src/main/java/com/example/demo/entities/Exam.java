package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {

	@Id
	private String code;

	private String date;

	private String time;

	@JsonIgnore
	@OneToMany(mappedBy = "exam")
	private List<Salle> salles;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "etudiant_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
	private List<Etudiant> etudiants;



	@OneToOne
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;;

	public Exam(String code,String date, String time,Matiere matiere) {
		this.code = code;
		this.date = date;
		this.time = time;
		this.matiere = matiere;
	
	}

	public Exam(List<Salle> salles) {

		this.salles = salles;
	}

	public Exam() {

	}

	public Exam(String date, String time, Matiere matiere) {

		this.date = date;
		this.time = time;
		this.salles = null;
		this.etudiants = null;
		this.matiere = matiere;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
