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
@Table(name = "semestres")
public class Semestre {

	@Id
	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "semestre")
	private List<Module> modules;

	public Semestre() {
	}

	public Semestre(String nom) {
		this.nom = nom;
		this.modules = null;
	}

	public Semestre(String nom, List<Module> modules) {
		this.nom = nom;
		this.modules = modules;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}
