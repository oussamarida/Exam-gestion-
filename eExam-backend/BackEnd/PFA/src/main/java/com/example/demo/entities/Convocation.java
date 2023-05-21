package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "convocations")
public class Convocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "etudiant_id")
	private Etudiant etudiant;

	private String Cr_M1;
	private String Cr_M2;
	private String Cr_M3;
	private String Cr_M4;
	private String Cr_M5;
	private String Cr_M6;
	private String Date_M1;
	private String Date_M2;
	private String Date_M3;
	private String Date_M4;
	private String Date_M5;
	private String Date_M6;
	private int Ex_M1;
	private int Ex_M2;
	private int Ex_M3;
	private int Ex_M4;
	private int Ex_M5;
	private int Ex_M6;
	private String Filiere;
	private String Loc_M1;
	private String Loc_M2;
	private String Loc_M3;
	private String Loc_M4;
	private String Loc_M5;
	private String Loc_M6;
	private String M1;
	private String M2;
	private String M3;
	private String M4;
	private String M5;
	private String M6;
	private int NTab_M1;
	private int NTab_M2;
	private int NTab_M3;
	private int NTab_M4;
	private int NTab_M5;
	private int NTab_M6;
	private String Semestre;

	public Convocation() {
		super();
	}

	public Convocation(String cr_M1, String cr_M2, String cr_M3, String cr_M4, String cr_M5, String cr_M6,
			String date_M1, String date_M2, String date_M3, String date_M4, String date_M5, String date_M6, int ex_M1,
			int ex_M2, int ex_M3, int ex_M4, int ex_M5, int ex_M6, String filiere, String loc_M1, String loc_M2,
			String loc_M3, String loc_M4, String loc_M5, String loc_M6, String m1, String m2, String m3, String m4,
			String m5, String m6, int nTab_M1, int nTab_M2, int nTab_M3, int nTab_M4, int nTab_M5, int nTab_M6,
			String semestre,Etudiant etudiant) {

		this.Cr_M1 = cr_M1;
		this.Cr_M2 = cr_M2;
		this.Cr_M3 = cr_M3;
		this.Cr_M4 = cr_M4;
		this.Cr_M5 = cr_M5;
		this.Cr_M6 = cr_M6;
		this.Date_M1 = date_M1;
		this.Date_M2 = date_M2;
		this.Date_M3 = date_M3;
		this.Date_M4 = date_M4;
		this.Date_M5 = date_M5;
		this.Date_M6 = date_M6;
		this.Ex_M1 = ex_M1;
		this.Ex_M2 = ex_M2;
		this.Ex_M3 = ex_M3;
		this.Ex_M4 = ex_M4;
		this.Ex_M5 = ex_M5;
		this.Ex_M6 = ex_M6;
		this.Filiere = filiere;
		this.Loc_M1 = loc_M1;
		this.Loc_M2 = loc_M2;
		this.Loc_M3 = loc_M3;
		this.Loc_M4 = loc_M4;
		this.Loc_M5 = loc_M5;
		this.Loc_M6 = loc_M6;
		this.M1 = m1;
		this.M2 = m2;
		this.M3 = m3;
		this.M4 = m4;
		this.M5 = m5;
		this.M6 = m6;
		this.NTab_M1 = nTab_M1;
		this.NTab_M2 = nTab_M2;
		this.NTab_M3 = nTab_M3;
		this.NTab_M4 = nTab_M4;
		this.NTab_M5 = nTab_M5;
		this.NTab_M6 = nTab_M6;
		this.Semestre = semestre;
		this.etudiant = etudiant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getCr_M1() {
		return Cr_M1;
	}

	public void setCr_M1(String cr_M1) {
		Cr_M1 = cr_M1;
	}

	public String getCr_M2() {
		return Cr_M2;
	}

	public void setCr_M2(String cr_M2) {
		Cr_M2 = cr_M2;
	}

	public String getCr_M3() {
		return Cr_M3;
	}

	public void setCr_M3(String cr_M3) {
		Cr_M3 = cr_M3;
	}

	public String getCr_M4() {
		return Cr_M4;
	}

	public void setCr_M4(String cr_M4) {
		Cr_M4 = cr_M4;
	}

	public String getCr_M5() {
		return Cr_M5;
	}

	public void setCr_M5(String cr_M5) {
		Cr_M5 = cr_M5;
	}

	public String getCr_M6() {
		return Cr_M6;
	}

	public void setCr_M6(String cr_M6) {
		Cr_M6 = cr_M6;
	}

	public String getDate_M1() {
		return Date_M1;
	}

	public void setDate_M1(String date_M1) {
		Date_M1 = date_M1;
	}

	public String getDate_M2() {
		return Date_M2;
	}

	public void setDate_M2(String date_M2) {
		Date_M2 = date_M2;
	}

	public String getDate_M3() {
		return Date_M3;
	}

	public void setDate_M3(String date_M3) {
		Date_M3 = date_M3;
	}

	public String getDate_M4() {
		return Date_M4;
	}

	public void setDate_M4(String date_M4) {
		Date_M4 = date_M4;
	}

	public String getDate_M5() {
		return Date_M5;
	}

	public void setDate_M5(String date_M5) {
		Date_M5 = date_M5;
	}

	public String getDate_M6() {
		return Date_M6;
	}

	public void setDate_M6(String date_M6) {
		Date_M6 = date_M6;
	}

	public int getEx_M1() {
		return Ex_M1;
	}

	public void setEx_M1(int ex_M1) {
		Ex_M1 = ex_M1;
	}

	public int getEx_M2() {
		return Ex_M2;
	}

	public void setEx_M2(int ex_M2) {
		Ex_M2 = ex_M2;
	}

	public int getEx_M3() {
		return Ex_M3;
	}

	public void setEx_M3(int ex_M3) {
		Ex_M3 = ex_M3;
	}

	public int getEx_M4() {
		return Ex_M4;
	}

	public void setEx_M4(int ex_M4) {
		Ex_M4 = ex_M4;
	}

	public int getEx_M5() {
		return Ex_M5;
	}

	public void setEx_M5(int ex_M5) {
		Ex_M5 = ex_M5;
	}

	public int getEx_M6() {
		return Ex_M6;
	}

	public void setEx_M6(int ex_M6) {
		Ex_M6 = ex_M6;
	}

	public String getFiliere() {
		return Filiere;
	}

	public void setFiliere(String filiere) {
		Filiere = filiere;
	}

	public String getLoc_M1() {
		return Loc_M1;
	}

	public void setLoc_M1(String loc_M1) {
		Loc_M1 = loc_M1;
	}

	public String getLoc_M2() {
		return Loc_M2;
	}

	public void setLoc_M2(String loc_M2) {
		Loc_M2 = loc_M2;
	}

	public String getLoc_M3() {
		return Loc_M3;
	}

	public void setLoc_M3(String loc_M3) {
		Loc_M3 = loc_M3;
	}

	public String getLoc_M4() {
		return Loc_M4;
	}

	public void setLoc_M4(String loc_M4) {
		Loc_M4 = loc_M4;
	}

	public String getLoc_M5() {
		return Loc_M5;
	}

	public void setLoc_M5(String loc_M5) {
		Loc_M5 = loc_M5;
	}

	public String getLoc_M6() {
		return Loc_M6;
	}

	public void setLoc_M6(String loc_M6) {
		Loc_M6 = loc_M6;
	}

	public String getM1() {
		return M1;
	}

	public void setM1(String m1) {
		M1 = m1;
	}

	public String getM2() {
		return M2;
	}

	public void setM2(String m2) {
		M2 = m2;
	}

	public String getM3() {
		return M3;
	}

	public void setM3(String m3) {
		M3 = m3;
	}

	public String getM4() {
		return M4;
	}

	public void setM4(String m4) {
		M4 = m4;
	}

	public String getM5() {
		return M5;
	}

	public void setM5(String m5) {
		M5 = m5;
	}

	public String getM6() {
		return M6;
	}

	public void setM6(String m6) {
		M6 = m6;
	}

	public int getNTab_M1() {
		return NTab_M1;
	}

	public void setNTab_M1(int nTab_M1) {
		NTab_M1 = nTab_M1;
	}

	public int getNTab_M2() {
		return NTab_M2;
	}

	public void setNTab_M2(int nTab_M2) {
		NTab_M2 = nTab_M2;
	}

	public int getNTab_M3() {
		return NTab_M3;
	}

	public void setNTab_M3(int nTab_M3) {
		NTab_M3 = nTab_M3;
	}

	public int getNTab_M4() {
		return NTab_M4;
	}

	public void setNTab_M4(int nTab_M4) {
		NTab_M4 = nTab_M4;
	}

	public int getNTab_M5() {
		return NTab_M5;
	}

	public void setNTab_M5(int nTab_M5) {
		NTab_M5 = nTab_M5;
	}

	public int getNTab_M6() {
		return NTab_M6;
	}

	public void setNTab_M6(int nTab_M6) {
		NTab_M6 = nTab_M6;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
}
