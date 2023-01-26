package com.example.hibernate.repository;

import com.example.hibernate.model.Mark;
import com.example.hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;



public class CustomStudentRepositoryImpl implements CustomStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> getAll() {
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> students = (List<Student>) query.getResultList();
        return students;
    }

    @Override
    public Student getByName(String pattern) {

        Query query = entityManager
                    .createQuery("select s from Student s where s.name like '%" + pattern + "%'");
        return (Student) query.getSingleResult();

    }

    @Override
    public boolean deleteById(int id) {
        entityManager.createQuery("delete from Student where id = '%" + id + "%'");
        return true;
    }

    @Override
    public boolean updateById(int id, int newId, String name, String email) {
        entityManager.createQuery("update Student s " +
                "set s.id = '%" + id + "%', s.name = '%" + name + "%', " +
                "s.email = '%" + email + "%' where s.id = '%" + id + "%'").executeUpdate();
        return true;
    }

    @Override
    public boolean add(int id, String name, String email) {
        entityManager.createQuery("");
        return true;
    }


}
