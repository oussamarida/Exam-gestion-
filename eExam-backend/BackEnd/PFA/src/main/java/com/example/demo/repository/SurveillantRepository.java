package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Surveillant;

@Repository
public interface SurveillantRepository extends JpaRepository<Surveillant, Long> {
    // You can add custom query methods here if needed
    
    // Find a Surveillant by ID
    Surveillant findById(long id);
}
