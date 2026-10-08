package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student student) {
    Student existingStudent = studentRepository.findById(id).orElse(null);

    if (existingStudent == null) {
        return null;
    }

    existingStudent.setName(student.getName());
    existingStudent.setDepartment(student.getDepartment());
    existingStudent.setCgpa(student.getCgpa());

    return studentRepository.save(existingStudent);
}
public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
}
}