package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.JobService;
import com.example.HRMS.core.results.*;
import com.example.HRMS.dataAccess.abstracts.JobDao;
import com.example.HRMS.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public Result add(Job job) {
        if(getByName(job.getName()).getData() != null){
            return new ErrorResult("Aynı iş zaten var.");
        }
        this.jobDao.save(job);
        return new SuccessResult("İş eklendi");
    }

    @Override
    public DataResult<Job> getByName(String name) {
        return new SuccessDataResult<>(this.jobDao.getByName(name));
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<>(this.jobDao.findAll());
    }

}
