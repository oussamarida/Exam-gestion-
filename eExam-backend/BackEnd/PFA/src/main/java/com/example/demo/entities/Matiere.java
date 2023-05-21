package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matieres")
public class Matiere {

	@Id
	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "prefesseur_id")
	private Professeur professeur;

	@JsonIgnore
	@OneToOne(mappedBy = "matiere")
	private Exam exam;

	public Matiere(String nom) {

		this.module = null;
		this.filiere = null;
		this.professeur = null;
		this.exam = null;
		this.nom = nom;
	}

	public Matiere(Filiere filiere, String nom) {

		this.module = null;
		this.filiere = filiere;
		this.professeur = null;
		this.exam = null;
		this.nom = nom;
	}

	public Matiere() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
