package org.example.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImp implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImp(EntityManager em) {
        this.entityManager = em;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
