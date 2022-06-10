package com.example.studentlistmanaging.repository;

import com.example.studentlistmanaging.model.Student;
import jakarta.persistence.*;

import java.util.List;

public class StudentRepository {
    private static StudentRepository instance;
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pers_unit");
    private final static EntityManager em = emf.createEntityManager();
    private final static EntityTransaction transac = em.getTransaction();

    private StudentRepository() {
        transac.begin();
    }

    public static StudentRepository getInstance() {
        if (instance == null)
            instance = new StudentRepository();
        return instance;
    }


    public void save(Student student) {
        if (student != null){
            em.persist(student);
            StudentRepository.transac.commit();
        }
    }

    public List<Student> findAll() {
        Query query = em.createQuery("select s from Student s");
        return (List<Student>) query.getResultList();
    }

    public Student findByMatricule(String matricule) {
        return em.find(Student.class, matricule);
    }

    public void removeByMatricule(String matricule) {
        Student student = findByMatricule(matricule);
        if (student != null)
            em.remove(student);
    }

    public void updateStudent(Student student, String newMatricule) {
        Student oldStudent = findByMatricule(student.getMatricule());
        if (oldStudent != null) {
            oldStudent.setNom(student.getNom());
            oldStudent.setPrenom(student.getPrenom());
            oldStudent.setDate_naissance(student.getDate_naissance());
            oldStudent.setLieu_naissance(student.getLieu_naissance());
            oldStudent.setNationalite(student.getNationalite());
            oldStudent.setTel(student.getTel());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setPhoto(student.getPhoto());

            if (!newMatricule.isEmpty())
                oldStudent.setMatricule(newMatricule);

            em.flush();
            transac.commit();
        }
    }

    public static EntityManager getEm() {
        return StudentRepository.em;
    }

    public static EntityManagerFactory getEmf() {
        return StudentRepository.emf;
    }
}
