package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "modules")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "semestre_id")
	private Semestre semestre;

	@JsonIgnore
	@OneToMany(mappedBy = "module")
	private List<Matiere> Matiere;

	public Module() {
		super();
	}
	public Module( String nom, Semestre semestre) {
		this.nom = nom;
		this.semestre = semestre;
		Matiere = null;
	}

	public Module( String nom, Semestre semestre, List<Matiere> matiere) {
		this.nom = nom;
		this.semestre = semestre;
		Matiere = matiere;
	}

	public Module(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
