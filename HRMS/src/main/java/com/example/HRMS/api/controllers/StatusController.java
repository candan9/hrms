package com.example.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.StatusService;
import com.example.HRMS.entities.concretes.Status;

@RestController
@RequestMapping("/api/statuses")
@CrossOrigin
public class StatusController {

	 private StatusService statusService;

	    @Autowired
	    public StatusController(StatusService statusService) {
	        this.statusService = statusService;
	    }

	    @PostMapping("/add")
	    public ResponseEntity<?> add(Status status){
	        return ResponseEntity.ok(this.statusService.add(status));
	    }

	    @GetMapping("/getbyname")
	    public ResponseEntity<?> getByName(@RequestParam String name){
	        return ResponseEntity.ok(this.statusService.getByName(name));
	    }

	    @GetMapping("/getall")
	    public ResponseEntity<?> getAll(){
	        return ResponseEntity.ok(this.statusService.getAll());
	    }
}
