package com.example.hibernate.repository;

import com.example.hibernate.model.Mark;
import com.example.hibernate.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomStudentRepository {

    List<Student> getAll();
    Student getByName(String pattern);
    boolean deleteById(int id);
    boolean updateById(int id, int newId, String name, String email);
    boolean add(int id, String name, String email);


}
