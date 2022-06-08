package com.example.studentlistmanaging.controller;

import com.example.studentlistmanaging.model.Student;
import com.example.studentlistmanaging.repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    private final StudentRepository repository = StudentRepository.getInstance();

    @FXML
    protected void onHelloButtonClick() {
        LocalDate date = LocalDate.of(1998, 8, 17);


        Student student = new Student();
        student.setMatricule("1234A");
        student.setNom("ZO");
        student.setPrenom("Mamadou");
        student.setDate_naissance(date);
        student.setLieu_naissance("Livreville");
        student.setNationalite("Burkinabè");
        student.setEmail("zomamadou9@gmail.com");
        student.setTel("64774850");
        student.setPhoto("C:/user/BIGZO/img1.jpg");

        repository.save(student);

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void showAllStudents() {
        List<Student> studentList = repository.findAll();
        System.out.println("********************************");
        System.out.println("* Matricule | Nom     | Prenom *");
        System.out.println("********************************");
        for ( Student student : studentList ) {
            System.out.println("* " + student.getMatricule() + " | " + student.getNom() + " | " + student.getPrenom() + " *");
        }
        System.out.println("********************************");
    }

    @FXML
    protected void showOneStudent() {
        Student student = repository.findByMatricule("1234A");
        System.out.println("********************************");
        System.out.println("* Matricule | Nom     | Prenom *");
        System.out.println("********************************");
        System.out.println("* " + student.getMatricule() + " | " + student.getNom() + " | " + student.getPrenom() + " *");
        System.out.println("********************************");

    }
}