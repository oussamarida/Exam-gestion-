package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Convocation;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Professeur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.ProfesseurRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;

	@GetMapping("/admin")
	public Admin login1(@RequestParam String email, @RequestParam String password) {
		Admin admin = adminRepository.findByEmail(email);

		if (admin != null && admin.getPassword().equals(password)) {

			return admin;
		} else {

			return null;
		}

	}


	@GetMapping("/etudiant")
	public Convocation login3(@RequestParam String email, @RequestParam String password) {
		Etudiant etudiant = etudiantRepository.findByEmail(email);
		if (etudiant != null && etudiant.getPassword().equals(password)) {

			return etudiant.getConvocation();
		} else {

			return null;
		}

	}

	
}
