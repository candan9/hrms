package com.example.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.EmploymentService;
import com.example.HRMS.entities.concretes.Employment;

@RestController
@RequestMapping("/api/employments")
@CrossOrigin
public class EmploymentsController {

    private EmploymentService employmentService;

    @Autowired
    public EmploymentsController(EmploymentService employmentService) {
        this.employmentService = employmentService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Employment employment){
        return ResponseEntity.ok(this.employmentService.add(employment));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.employmentService.getAll());
    }
}
