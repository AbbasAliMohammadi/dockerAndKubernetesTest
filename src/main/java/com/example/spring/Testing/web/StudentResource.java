package com.example.spring.Testing.web;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Testing.domain.Student;
import com.example.spring.Testing.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("api/student")
@Slf4j
public class StudentResource {
 private final StudentService studentService;
   
 @PostMapping
 public ResponseEntity<Student> save(@RequestBody Student student){
    return ResponseEntity.ok(studentService.Save(student));
 }

 @GetMapping
 public ResponseEntity<List<Student>> viewAll(){
    List<Student> students=studentService.viewAll();
    return ResponseEntity.ok(studentService.viewAll());
 }


}
