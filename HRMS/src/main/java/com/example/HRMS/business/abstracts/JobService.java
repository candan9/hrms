package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Job;

import java.util.List;

public interface JobService {

    Result add(Job job);
    DataResult<Job> getByName(String name);
    DataResult<List<Job>> getAll();

}
