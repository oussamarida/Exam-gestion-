package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepository;

@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;


    @GetMapping("/{id}/")
    public ResponseEntity<String> updateAdminPassword(
            @PathVariable("id") Long id,
            @RequestParam String password
    ) {
        Admin admin = adminRepository.findById(id);
        admin.setPassword(password);
        adminRepository.save(admin);

        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }

}
