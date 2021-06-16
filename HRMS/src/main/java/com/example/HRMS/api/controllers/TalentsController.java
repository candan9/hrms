package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.TalentService;
import com.example.HRMS.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talents")
public class TalentsController {

    private TalentService talentService;

    @Autowired
    public TalentsController(TalentService talentService) {
        this.talentService = talentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Talent talent){
        return ResponseEntity.ok(this.talentService.add(talent));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.talentService.getAll());
    }
}
