package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.JobAdvService;
import com.example.HRMS.business.abstracts.JobAdvStatusService;
import com.example.HRMS.core.results.*;
import com.example.HRMS.dataAccess.abstracts.JobAdvDao;
import com.example.HRMS.entities.concretes.JobAdv;
import com.example.HRMS.entities.concretes.JobAdvStatus;
import com.example.HRMS.entities.concretes.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvManager implements JobAdvService {

    private JobAdvDao jobAdvDao;
    private JobAdvStatusService jobAdvStatusService;
    @Autowired
    public JobAdvManager(JobAdvDao jobAdvDao) {
        this.jobAdvDao = jobAdvDao;
    }


    @Override
    public Result add( JobAdv jobAdv) {
    	jobAdv.setPublishedAt(LocalDate.now());
        this.jobAdvDao.save(jobAdv);
        JobAdvStatus jobPostingStatusWaiting = new JobAdvStatus(0,LocalDate.now(),jobAdv,null,new Status(1,null,null));
        this.jobAdvStatusService.add(jobPostingStatusWaiting);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public Result toggleActiveStatus(int id) {
    	JobAdv jobPostingToChange = this.jobAdvDao.findById(id).get();
        jobPostingToChange.setActive(!jobPostingToChange.isActive());
        this.jobAdvDao.save(jobPostingToChange);
        return new SuccessResult("Başarılı!");
    }

    @Override
    public DataResult<List<JobAdv>> getAll() {
        return new SuccessDataResult<>(this.jobAdvDao.findAll());
    }

    @Override
    public DataResult<List<JobAdv>> getAllByApplicationDeadline(LocalDate date) {
        return new SuccessDataResult<>(this.jobAdvDao.getAllByApplicationDeadlineLessThanEqual(date));
    }

    @Override
    public DataResult<List<JobAdv>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<>(this.jobAdvDao.getAllByEmployer(employerId));
    }

	@Override
	public DataResult<JobAdv> getById(int id) {
        return new SuccessDataResult<>(this.jobAdvDao.findById(id).get());
	}

	@Override
	public DataResult<List<JobAdv>> getAllByStatusId(int statusId) {
		// TODO Auto-generated method stub
		 return new SuccessDataResult<>(this.jobAdvDao.getAllByStatusName(statusId));
	}
}
