package com.example.hibernate.repository;

import com.example.hibernate.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCrudRepository extends CrudRepository<Student, Integer>, CustomStudentRepository{

}
