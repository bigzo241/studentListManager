package com.example.studentlistmanaging.repository;

import com.example.studentlistmanaging.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentRepository {

    public void save(Student student) {
//       initialisation des variables
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pers_unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
//        debut de la transaction
        transac.begin();
        em.persist(student);
//        validation de la transaction
        transac.commit();
//        fermerture de la transaction
        em.close();
        emf.close();
    }
}
