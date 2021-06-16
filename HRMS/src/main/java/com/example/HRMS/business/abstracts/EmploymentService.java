package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Employment;

public interface EmploymentService {
    Result add(Employment employment);
    DataResult<List<Employment>> getAll();
}