package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.entities.concretes.Job;

public interface JobService {
       List<Job> getAll();
}