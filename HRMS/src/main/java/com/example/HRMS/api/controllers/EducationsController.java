package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.EducationService;
import com.example.HRMS.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Education education){
        return ResponseEntity.ok(this.educationService.add(education));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.educationService.getAll());
    }

    @GetMapping("/getallbycandidateidorderbygraduationyear")
    public ResponseEntity<?> getAllByCandidateIdOrderByGraduationYear(@RequestParam int candidateId){
        return ResponseEntity.ok(this.educationService.getAllByCandidateIdOrderByGraduationYear(candidateId));
    }
}
