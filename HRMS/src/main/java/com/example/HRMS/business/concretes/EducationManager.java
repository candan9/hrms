package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.EducationService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.EducationDao;
import com.example.HRMS.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(educationDao.findAll());
    }

    @Override
    public DataResult<List<Education>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
        return new SuccessDataResult<>(educationDao.getAllByCandidateIdOrderByGraduationYear(candidateId));
    }
}
