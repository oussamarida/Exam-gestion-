package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Convocation;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Exam;
import com.example.demo.entities.Filiere;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Semestre;
import com.example.demo.entities.Tab;
import com.example.demo.idao.RandomNumberGenerator;
import com.example.demo.repository.ConvocationRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.MatiereRepository;
import com.example.demo.repository.PersonneRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.SemestreRepository;
import com.example.demo.repository.TabRepository;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private SemestreRepository semestreRepository;

	@Autowired
	private FiliereRepository filiereRepository;
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private TabRepository tabRepository;

	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private ConvocationRepository convocationRepository;

	private Matiere createMatiere(Filiere filiere, String matiereName) {

		Matiere matiere = matiereRepository.findByNom(matiereName);
		if (matiere == null) {
			matiere = new Matiere(filiere, matiereName);
			matiereRepository.save(matiere);
		}
		return matiere;
	}

	private Exam createExam(String date, String time, Matiere matiere) {
		Exam exam = examRepository.findByCode(date + time.substring(0, 10) + matiere.getNom());
		if (exam == null) {
			exam = new Exam(date + time.substring(0, 10) + matiere.getNom(), date, time.substring(0, 10), matiere);
			examRepository.save(exam);
		} else {
			exam = examRepository.findByCode(date + time.substring(0, 10) + matiere.getNom());
		}
		return exam;
	}

	private Salle createSalle(String name, Exam exam) {
		Salle salle = salleRepository
				.findByCode(name + exam.getDate() + exam.getTime().substring(0, 10) + exam.getMatiere().getNom());
		if (salle == null) {
			salle = new Salle(name + exam.getDate() + exam.getTime().substring(0, 10) + exam.getMatiere().getNom(),
					name, exam);
			salleRepository.save(salle);
		} else {
			salle = salleRepository
					.findByCode(name + exam.getDate() + exam.getTime().substring(0, 10) + exam.getMatiere().getNom());
		}

		return salle;
	}

	@PostMapping("/save")
	public void createfiliere(@RequestParam String cne, @RequestParam String Cr_M1, @RequestParam String Cr_M2,
			@RequestParam String Cr_M3, @RequestParam String Cr_M4, @RequestParam String Cr_M5,
			@RequestParam String Cr_M6, @RequestParam String Date_M1, @RequestParam String Date_M2,
			@RequestParam String Date_M3, @RequestParam String Date_M4, @RequestParam String Date_M5,
			@RequestParam String Date_M6, @RequestParam int Ex_M1, @RequestParam int Ex_M2, @RequestParam int Ex_M3,
			@RequestParam int Ex_M4, @RequestParam int Ex_M5, @RequestParam int Ex_M6, @RequestParam String Filiere,
			@RequestParam String Loc_M1, @RequestParam String Loc_M2, @RequestParam String Loc_M3,
			@RequestParam String Loc_M4, @RequestParam String Loc_M5, @RequestParam String Loc_M6,
			@RequestParam String M1, @RequestParam String M2, @RequestParam String M3, @RequestParam String M4,
			@RequestParam String M5, @RequestParam String M6, @RequestParam int NTab_M1, @RequestParam int NTab_M2,
			@RequestParam int NTab_M3, @RequestParam int NTab_M4, @RequestParam int NTab_M5, @RequestParam int NTab_M6,
			@RequestParam long N_Apo, @RequestParam String Nom, @RequestParam String Prenom,
			@RequestParam String Semestre) {

		Salle salle1 = null;
		Salle salle2 = null;
		Salle salle3 = null;
		Salle salle4 = null;
		Salle salle5 = null;
		Salle salle6 = null;

		Semestre semestre = semestreRepository.findByNom(Semestre);
		if (semestre == null) {
			semestre = new Semestre(Semestre);
			semestreRepository.save(semestre);
		} else {
			semestre = semestreRepository.findByNom(Semestre);

		}

		Filiere filiere = filiereRepository.findByNom(Filiere);
		if (filiere == null) {
			filiere = new Filiere(Filiere);
			filiereRepository.save(filiere);
		} else {
			filiere = filiereRepository.findByNom(Filiere);
		}
		List<Exam> exams = new ArrayList<Exam>();
		if (Ex_M1 == 1) {
			Matiere matiere = createMatiere(filiere, M1);
			Exam exam = createExam(Date_M1, Cr_M1, matiere);
			exams.add(exam);
			salle1 = createSalle(Loc_M1, exam);

		}

		if (Ex_M2 == 1) {
			Matiere matiere = createMatiere(filiere, M2);
			Exam exam = createExam(Date_M2, Cr_M2, matiere);
			exams.add(exam);
			salle2 = createSalle(Loc_M2, exam);
		}

		if (Ex_M3 == 1) {
			Matiere matiere = createMatiere(filiere, M3);
			Exam exam = createExam(Date_M3, Cr_M3, matiere);
			exams.add(exam);
			salle3 = createSalle(Loc_M3, exam);
		}

		if (Ex_M4 == 1) {
			Matiere matiere = createMatiere(filiere, M4);
			Exam exam = createExam(Date_M4, Cr_M4, matiere);
			exams.add(exam);
			salle4 = createSalle(Loc_M4, exam);
		}

		if (Ex_M5 == 1) {
			Matiere matiere = createMatiere(filiere, M5);
			Exam exam = createExam(Date_M5, Cr_M5, matiere);
			exams.add(exam);
			salle5 = createSalle(Loc_M5, exam);
		}

		if (Ex_M6 == 1) {
			Matiere matiere = createMatiere(filiere, M6);
			Exam exam = createExam(Date_M6, Cr_M6, matiere);
			exams.add(exam);
			salle6 = createSalle(Loc_M6, exam); 
		}
		Etudiant etudiant = etudiantRepository.findByNApo(N_Apo);
		if (etudiant == null) {
			String email = Prenom +cne+ RandomNumberGenerator.getRandomNumber() + "email.com";
			String password = "123";
			etudiant = new Etudiant(cne, Nom, Prenom, N_Apo, email, password, exams);
			etudiantRepository.save(etudiant); 
		}
		if (Ex_M1 == 1) {
			Tab tab = new Tab(NTab_M1, salle1, etudiant);
			tabRepository.save(tab);
		}
 
		if (Ex_M2 == 1) {
			Tab tab = new Tab(NTab_M2, salle2, etudiant);
			tabRepository.save(tab);
		}

		if (Ex_M3 == 1) {
			Tab tab = new Tab(NTab_M3, salle3, etudiant);
			tabRepository.save(tab);
		}

		if (Ex_M4 == 1) {
			Tab tab = new Tab(NTab_M4, salle4, etudiant);
			tabRepository.save(tab);
		}

		if (Ex_M5 == 1) {
			Tab tab = new Tab(NTab_M5, salle5, etudiant);
			tabRepository.save(tab);
		}

		if (Ex_M6 == 1) {
			Tab tab = new Tab(NTab_M6, salle6, etudiant);
			tabRepository.save(tab);
		}

		convocationRepository.save(new Convocation(Cr_M1, Cr_M2, Cr_M3, Cr_M4, Cr_M5, Cr_M6, Date_M1, Date_M2, Date_M3,
				Date_M4, Date_M5, Date_M6, Ex_M1, Ex_M2, Ex_M3, Ex_M4, Ex_M5, Ex_M6, Filiere, Loc_M1, Loc_M2, Loc_M3,
				Loc_M4, Loc_M5, Loc_M6, M1, M2, M3, M4, M5, M6, NTab_M1, NTab_M2, NTab_M3, NTab_M4, NTab_M5, NTab_M6,
				Semestre,etudiant));

	} 

}
