package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.ForLanguageService;
import com.example.HRMS.entities.concretes.ForLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/forlanguages")
public class ForLanguagesController {
    private ForLanguageService forLanguageService;

    @Autowired
    public ForLanguagesController(ForLanguageService candidateLanguageService) {
        this.forLanguageService = candidateLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid ForLanguage forLanguage){
        return ResponseEntity.ok(this.forLanguageService.add(forLanguage));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.forLanguageService.getAll());
    }
}
