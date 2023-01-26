package com.example.hibernate.dto;

import com.example.hibernate.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private String discipline;
    private int value;

}
