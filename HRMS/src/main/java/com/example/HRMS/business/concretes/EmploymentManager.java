package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmploymentService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.EmploymentDao;
import com.example.HRMS.entities.concretes.Employment;
@Service
public class EmploymentManager implements EmploymentService {

    private EmploymentDao employmentDao;

    @Autowired
    public EmploymentManager(EmploymentDao employmentDao) {
        this.employmentDao = employmentDao;
    }


    @Override
    public Result add(Employment employment) {
        this.employmentDao.save(employment);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Employment>> getAll() {
        return new SuccessDataResult<>(this.employmentDao.findAll());
    }
}
