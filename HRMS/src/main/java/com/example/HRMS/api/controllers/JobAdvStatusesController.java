package com.example.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobAdvStatusService;
import com.example.HRMS.entities.concretes.JobAdvStatus;

@RestController
@RequestMapping("/api/jobadvstatuses")
@CrossOrigin
public class JobAdvStatusesController {

    private JobAdvStatusService jobAdvStatusService;

    @Autowired
    public JobAdvStatusesController(JobAdvStatusService jobAdvStatusService) {
        this.jobAdvStatusService = jobAdvStatusService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobAdvStatus jobAdvStatus){
        return ResponseEntity.ok(this.jobAdvStatusService.add(jobAdvStatus));
    }

    @GetMapping("/getlastbyjobpostingid")
    public ResponseEntity<?> getLastByJobPostingId(@RequestParam int jobAdvId){
        return ResponseEntity.ok(this.jobAdvStatusService.getLastByJobAdvId(jobAdvId));
    }

    @GetMapping("/getallbyjobpostingid")
    public ResponseEntity<?> getAllByJobPostingId(@RequestParam int jobAdvId){
        return ResponseEntity.ok(this.jobAdvStatusService.getAllByJobAdvId(jobAdvId));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobAdvStatusService.getAll());
    }
}