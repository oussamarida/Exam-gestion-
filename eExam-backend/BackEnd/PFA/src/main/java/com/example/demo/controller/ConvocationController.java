package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Convocation;
import com.example.demo.repository.ConvocationRepository;

@RestController
@RequestMapping("/convocations")
public class ConvocationController {
	@Autowired
	private ConvocationRepository convocationRepository;

	@GetMapping("/find/{etudiantId}")
	public Convocation findByEtudiantId(@PathVariable int etudiantId) {

		return convocationRepository.findByEtudiantId(etudiantId);
	}

}
