package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.dtos.LoginUserDto;
import com.example.HRMS.entities.dtos.RegisterCandidateDto;
import com.example.HRMS.entities.dtos.RegisterEmployerDto;

public interface AuthService {

    Result registerEmployer(RegisterEmployerDto registerEmployerDto);
    Result registerCandidate(RegisterCandidateDto registerJobSeekerDto);
    Result login(LoginUserDto loginUserDto);

}
