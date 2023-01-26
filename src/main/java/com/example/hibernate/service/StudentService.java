package com.example.hibernate.service;

import com.example.hibernate.dto.MarkDto;
import com.example.hibernate.dto.StudentDto;
import com.example.hibernate.model.Mark;
import com.example.hibernate.model.Student;
import com.example.hibernate.repository.MarkRepository;
import com.example.hibernate.repository.StudentCrudRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final ObjectMapper objectMapper;
    private final MarkRepository markRepository;

    private final StudentCrudRepository studentCrudRepository;

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = objectMapper.convertValue(studentDto, Student.class);
        studentCrudRepository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    public MarkDto addMark(int studentId, int value, String discipline) {
        var mark = new Mark();
        mark.setDiscipline(discipline);
        mark.setValue(value);
        Optional<Student> student = studentCrudRepository.findById(studentId);
        mark.setStudent(student.orElseThrow(
                () -> new EntityNotFoundException("Student with id=" + studentId + " wasnt found"))
        );
        markRepository.save(mark);
        return objectMapper.convertValue(mark, MarkDto.class);
    }

    public void deleteById(int id) {
        studentCrudRepository.deleteById(id);
    }


}
