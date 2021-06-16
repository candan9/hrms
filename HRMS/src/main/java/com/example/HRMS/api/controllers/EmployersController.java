package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }


    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

}
