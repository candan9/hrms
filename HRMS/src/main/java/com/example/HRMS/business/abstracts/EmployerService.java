package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
}
