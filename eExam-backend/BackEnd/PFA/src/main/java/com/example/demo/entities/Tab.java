package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tables")
public class Tab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbsence() {
		return absence;
	}

	public void setAbsence(String absence) {
		this.absence = absence;
	}

	String num;
	String absence;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;  

	
	@ManyToOne
	@JoinColumn(name = "etudiant")
	private Etudiant etudiant;

	public Tab(int  num, Salle salle, Etudiant etudiant) {
		String r = Integer.toString(num);
		this.num = r;
		this.salle = salle; 
		this.etudiant = etudiant;
	}

	public Tab(String num, Salle salle) {

		this.num = num;
		this.salle = salle;
	}

	public Tab() {
		super();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}
