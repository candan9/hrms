package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.AuthService;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.dtos.RegisterCandidateDto;
import com.example.HRMS.entities.dtos.RegisterEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registeremployer")
    public Result registerEmployer(@RequestBody RegisterEmployerDto registerEmployerDto) {
        return authService.registerEmployer(registerEmployerDto);
    }

    @PostMapping("/registercandidate")
    public Result registerCandidate(@RequestBody RegisterCandidateDto registerCandidateDto) {
        return authService.registerCandidate(registerCandidateDto);
    }

}
