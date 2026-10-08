package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Student;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Error handling
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Student> getEligibleStudents(Long companyId) {

        Company company = companyRepository.findById(companyId)
        .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Company not found"
        ));

        double minimumCgpa = company.getMinimumCgpa();

        return studentRepository.findByCgpaGreaterThanEqual(minimumCgpa);
    }
}