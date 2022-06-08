package com.example.studentlistmanaging.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;


@Entity
@Table(name = "student")
public class Student {

    @Id
    private String matricule;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;

    private LocalDate date_naissance;
    private String lieu_naissance;
    private String nationalite;

    @Email
    private String email;
    private String tel;
    private String photo;

    public Student(String matricule, String nom, String prenom, LocalDate date_naissance, String lieu_naissance, String nationalite, String email, String tel, String photo) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.nationalite = nationalite;
        this.email = email;
        this.tel = tel;
        this.photo = photo;
    }

    public Student() {}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
