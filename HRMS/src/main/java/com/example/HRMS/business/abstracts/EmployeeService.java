package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Employee;

public interface EmployeeService {
    Result add(Employee employee);
    DataResult<List<Employee>> getAll();
}