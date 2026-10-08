package com.example.demo.model;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Student {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }


    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String department;
private double cgpa;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}
}