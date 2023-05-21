package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filieres")
public class Filiere {

	@Id
	@Column(name = "nom")
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "filiere")
	private List<Matiere> matieres;

	public Filiere() {
	}

	public Filiere(String nom) {
		this.nom = nom;
	}

	public Filiere(String nom, List<Matiere> matieres) {

		this.nom = nom;
		this.matieres = matieres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
}
