package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.JobAdv;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvService {

    Result add(JobAdv jobPosting);
    Result toggleActiveStatus(int id);
    DataResult<JobAdv> getById(int id);
    DataResult<List<JobAdv>> getAll();
    DataResult<List<JobAdv>> getAllByApplicationDeadline(LocalDate date);
    DataResult<List<JobAdv>> getAllByEmployerId(int employerId);
    DataResult<List<JobAdv>> getAllByStatusId(int statusId);
}
