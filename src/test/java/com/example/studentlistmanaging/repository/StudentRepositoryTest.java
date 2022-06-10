package com.example.studentlistmanaging.repository;

import com.example.studentlistmanaging.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryTest {

    private static StudentRepository repository;

    @BeforeAll
    static void init() {
        repository = StudentRepository.getInstance();
    }

    @Test
    public void testSave() {
//        Arrange
        Student student = new Student();
        student.setMatricule("1234D");
        student.setNom("LaFleur");
        student.setPrenom("Louis");
        student.setDate_naissance(LocalDate.of(1990, 4, 10));
        student.setLieu_naissance("Provence");
        student.setNationalite("Francais");
        student.setEmail("loutfktgykvbuy@gmail.com");
        student.setTel("+22612544565");
        student.setPhoto("url_photo");
//        Act
//        Student student1 = null;
        repository.save(student);
        Student result = repository.findByMatricule(student.getMatricule());
//        Assert
        Assertions.assertThat(result).isEqualTo(student);
    }

    @Test
    public void testFindbyMatricule() {
//        Act
        Student student = repository.findByMatricule("1234A");
//        Assert
        Assertions.assertThat(student.getNom()).isEqualTo("ZO");
    }

    @Test
    public void testFindAll() {
//        Act
        List<Student> studentList = repository.findAll();
//        Assert
        Assertions.assertThat(studentList).isExactlyInstanceOf(ArrayList.class);

    }

    @Test
    public void testRemoveByMatricule() {
//        Act
        repository.removeByMatricule("1234A");
        Student student = repository.findByMatricule("1234A");
//        Assert
        Assertions.assertThat(student).isEqualTo(null);
    }

    @Test
    public void testUpdateStudent() {
//        Arrange
        Student student = new Student();
        student.setMatricule("1234A");
        student.setNom("ZO");
        student.setPrenom("Mahamady");
        student.setDate_naissance(LocalDate.of(1996, 11, 22));
        student.setLieu_naissance("Livreville");
        student.setNationalite("Burkinabè");
        student.setEmail("zomamadou9@gmail.com");
        student.setTel("64774850");
        student.setPhoto("C:/user/BIGZO/img1.jpg");
//        Act
        repository.updateStudent(student, "");
        Student result = repository.findByMatricule("1234A");
//        Assert
        Assertions.assertThat(result.getPrenom()).isEqualTo("Mahamady");
        Assertions.assertThat(result.getDate_naissance()).isEqualTo("1996-11-22");
    }
}
