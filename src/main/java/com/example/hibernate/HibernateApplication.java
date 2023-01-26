package com.example.hibernate;


import com.example.hibernate.model.Student;
import com.example.hibernate.repository.StudentCrudRepository;
import com.example.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    @Autowired
    private StudentCrudRepository studentCrudRepository;
    @Autowired
    private StudentService studentService;


    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        List<Student> studentList = studentCrudRepository.getAll();
        Student student = studentCrudRepository.getByName("Bilba");
        //studentCrudRepository.deleteById(1);
        studentCrudRepository.updateById(1, 2, "Name2", "qwerty@gmail.com");
        //studentService.deleteById(1);
    }

}
