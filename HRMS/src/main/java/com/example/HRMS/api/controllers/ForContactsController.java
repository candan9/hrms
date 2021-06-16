package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.ForContactService;
import com.example.HRMS.entities.concretes.ForContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forcontacts")
public class ForContactsController {

    private ForContactService forLinkService;

    @Autowired
    public ForContactsController(ForContactService forLinkService) {
        this.forLinkService = forLinkService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ForContact forContact){
        return ResponseEntity.ok(this.forLinkService.add(forContact));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.forLinkService.getAll());
    }
}
