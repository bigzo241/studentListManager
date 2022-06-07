package com.example.studentlistmanaging.controller;

import com.example.studentlistmanaging.model.Student;
import com.example.studentlistmanaging.repository.StudentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private Label welcomeText;

    private final StudentRepository repository = new StudentRepository();

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
}