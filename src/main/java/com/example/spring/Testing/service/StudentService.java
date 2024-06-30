package com.example.spring.Testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.Testing.domain.Student;
import com.example.spring.Testing.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;

    public Student Save(Student student){
        return studentRepository.save(student);
    }
    public List<Student> viewAll(){
        return studentRepository.findAll();
    }
    
}
