package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiants")
@PrimaryKeyJoinColumn(name = "personne_id")
public class Etudiant extends Personne {

	@Column(name = "n_apo")
	private Long napo;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public Etudiant() {
		super();
	}

	@JsonIgnore
	@OneToOne(mappedBy = "etudiant")
	private Convocation convocation;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "etudiant_exam", joinColumns = @JoinColumn(name = "etudiant_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
	private List<Exam> exams = new ArrayList();
	@JsonIgnore
	@OneToMany(mappedBy = "etudiant")
	private List<Tab> tables;

	public Etudiant(String cne, String nom, String prenom, Long napo, String email, String password, List<Exam> exams) {
		super(cne, nom, prenom);
		this.napo = napo;
		this.email = email;
		this.password = password; 
		this.exams = exams;
	}

	public Etudiant(int id , Exam exam) {
		
		this.setId(id);
		this.exams.add(exam);
	
	}

	public Etudiant(String cne, String nom, String prenom, Long napo, String email, String password) {
		super(cne, nom, prenom);
		this.napo = napo;
		this.email = email;
		this.password = password;
	}

	public Long getNapo() {
		return napo;
	}

	public void setNapo(Long napo) {
		this.napo = napo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Convocation getConvocation() {
		return convocation;
	}

	public void setConvocation(Convocation convocation) {
		this.convocation = convocation;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Tab> getTables() {
		return tables;
	}

	public void setTables(List<Tab> tables) {
		this.tables = tables;
	}




}
