package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.JobAdvStatus;

public interface JobAdvStatusService {
	Result add(JobAdvStatus jobPostingStatus);
    DataResult<JobAdvStatus> getLastByJobAdvId(int jobPostingId);
    DataResult<List<JobAdvStatus>> getAllByJobAdvId(int jobPostingId);
    DataResult<List<JobAdvStatus>> getAll();
}
