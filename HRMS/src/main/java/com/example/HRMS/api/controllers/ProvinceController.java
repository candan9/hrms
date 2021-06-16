package com.example.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.ProvinceService;
import com.example.HRMS.entities.concretes.Province;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin
public class ProvinceController {
    private ProvinceService provinceService;

    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Province province){
        return ResponseEntity.ok(this.provinceService.add(province));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.provinceService.getAll());
    }
}