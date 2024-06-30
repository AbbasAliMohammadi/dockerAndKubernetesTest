package com.example.spring.Testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.Testing.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long>  {
    
}
