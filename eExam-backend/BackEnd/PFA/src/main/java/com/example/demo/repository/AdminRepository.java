package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

	Admin findById(Long id);
	
	
}
