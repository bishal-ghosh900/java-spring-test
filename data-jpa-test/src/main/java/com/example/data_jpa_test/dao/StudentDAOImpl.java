package com.example.data_jpa_test.dao;

import com.example.data_jpa_test.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudent() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("FROM Student", Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    public Student findStudentByName(String name) {
        String[] nameList = name.split(" ");
        String firstName = nameList[0];
        String lastName = nameList[1];
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(
                "FROM Student WHERE firstName=:firstName AND lastName=:lastName",
                Student.class
        );

        studentTypedQuery.setParameter("firstName", firstName);
        studentTypedQuery.setParameter("lastName", lastName);

        return studentTypedQuery.getResultList().get(0);
    }

    @Transactional
    public void save(List<Student> students) {
        for(Student student : students) {
            save(student);
        }
    }
}
