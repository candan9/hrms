package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobAdvStatusService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobAdvStatusDao;
import com.example.HRMS.entities.concretes.JobAdvStatus;

@Service
public class JobAdvStatusManager implements JobAdvStatusService {
	private JobAdvStatusDao jobAdvStatusDao;

    @Autowired
    public JobAdvStatusManager(JobAdvStatusDao jobAdvStatusDao) {
        this.jobAdvStatusDao = jobAdvStatusDao;
    }

    @Override
    public Result add(JobAdvStatus jobAdvStatus) {
        this.jobAdvStatusDao.save(jobAdvStatus);
        return new SuccessResult();
    }

    @Override
    public DataResult<JobAdvStatus> getLastByJobAdvId(int jobAdvId) {
        return new SuccessDataResult<>(this.jobAdvStatusDao.getTopByJobAdvIdOrderByIdDesc(jobAdvId));
    }

    @Override
    public DataResult<List<JobAdvStatus>> getAllByJobAdvId(int jobAdvId) {
        return new SuccessDataResult<>(this.jobAdvStatusDao.getAllByJobAdvId(jobAdvId));
    }

    @Override
    public DataResult<List<JobAdvStatus>> getAll() {
        return new SuccessDataResult<>(this.jobAdvStatusDao.findAll());
    }
}
