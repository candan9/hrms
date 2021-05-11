package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobService;
import com.example.HRMS.dataAccess.abstracts.JobDao;
import com.example.HRMS.entities.concretes.Job;
@Service
public class JobManager implements JobService {
    private JobDao jobDao;
    @Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	@Override
	public List<Job> getAll() {
		// TODO Auto-generated method stub
		return this.jobDao.findAll();
	}

}