package com.example.demo.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="professeurs")
@PrimaryKeyJoinColumn(name="personne_id")
public class Professeur extends Personne {

    @Column(name = "code")
    private long code;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @JsonIgnore
    @OneToMany(mappedBy = "professeur")
    private ArrayList<Matiere> modules = new ArrayList<Matiere>();

    public Professeur() {
        super();
    }

    public Professeur(String cin, String nom, String prenom, long code, String email, String password) {
        super(cin, nom, prenom);
        this.code = code;
        this.email = email;
        this.password = password;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}