package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.ExperienceService;
import com.example.HRMS.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Experience experience){
        return ResponseEntity.ok(this.experienceService.add(experience));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.experienceService.getAll());
    }

    @GetMapping("/getallbycandidateidorderbyleavedate")
    public ResponseEntity<?> getAllOrderByLeaveDate(@RequestParam int candidateId){
        return ResponseEntity.ok(this.experienceService.getAllByCandidateIdOrderByLeaveDate(candidateId));
    }

}
