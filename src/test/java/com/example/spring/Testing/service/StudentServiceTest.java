package com.example.spring.Testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.jdbc.Sql;

import com.example.spring.Testing.domain.Student;
import com.example.spring.Testing.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    
    @Test
    void testSave() {
     Student student =new Student();
     student.setName("abbas");
     student.setLastName("Mohammadi");
     when(studentRepository.save(student)).thenReturn(student);
     Student resault=studentService.Save(student);
     assertEquals(resault, student);
     }

    @Test
    void testViewAll() {
        Student student =new Student();
        student.setName("ali");
        student.setLastName("ahmadi");
       when(studentRepository.findAll()).thenReturn(List.of(student));
       assertEquals(studentService.viewAll().stream().findFirst().get().getLastName(), "ahmadi");
       
    }
}
