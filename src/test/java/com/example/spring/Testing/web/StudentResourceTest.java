package com.example.spring.Testing.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.spring.Testing.domain.Student;
import com.example.spring.Testing.repository.StudentRepository;
import com.example.spring.Testing.service.StudentService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@Slf4j
@SpringBootTest
public class StudentResourceTest {

    @InjectMocks
    StudentResource studentResource;

    @Mock
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;



    @Test
    void testSave() {
        Student student = new Student();
        student.setName("John Doe");
        student.setLastName("Smith");
        when(studentRepository.save(student)).thenReturn(student);
        Student sres=studentRepository.save(student);
        when(studentService.Save(student)).thenReturn(sres);

        ResponseEntity<Student> response = studentResource.save(student);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }
    @Test
    void testViewAll() {
        Student student = new Student();
        student.setName("ali");
        student.setLastName("ahmadi");
        when(studentRepository.findAll()).thenReturn(List.of(student));
        List<Student> res=studentRepository.findAll();
        when(studentService.viewAll()).thenReturn(res);

        ResponseEntity<List<Student>> response = studentResource.viewAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(student), response.getBody());
    }

 
}