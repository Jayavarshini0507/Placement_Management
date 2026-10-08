package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.model.Student;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}/eligible-students")
public List<Student> getEligibleStudents(@PathVariable Long companyId) {
    return companyService.getEligibleStudents(companyId);
}
}