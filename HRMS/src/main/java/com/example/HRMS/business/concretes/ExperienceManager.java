package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.ExperienceService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.ExperienceDao;
import com.example.HRMS.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience candidateExperience) {
        this.experienceDao.save(candidateExperience);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<>(this.experienceDao.findAll());
    }

    @Override
    public DataResult<List<Experience>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
        return new SuccessDataResult<>(this.experienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
    }
}
