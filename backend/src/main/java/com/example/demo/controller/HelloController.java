package com.example.demo.controller;
import com.example.demo.model.Student;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.StudentService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class HelloController {
    private final StudentService studentService;
    public HelloController(StudentService studentService) {
    this.studentService = studentService;
}
    @GetMapping("/")
    public String hello() {
        return "Placement Management Backend is Running!";
    }

 @GetMapping("/students")
public List<Student> students() {
    return studentService.getAllStudents();
}

@PostMapping("/students")
public Student addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
}

@PutMapping("/students/{id}")
public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
    return studentService.updateStudent(id, student);
}

@DeleteMapping("/students/{id}")
public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
}
}