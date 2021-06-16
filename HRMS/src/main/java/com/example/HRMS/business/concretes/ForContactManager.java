package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.ForContactService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.ForContactDao;
import com.example.HRMS.entities.concretes.ForContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForContactManager implements ForContactService {

    private ForContactDao forContactDao;

    @Autowired
    public ForContactManager(ForContactDao  forContactDao) {
        this.forContactDao =  forContactDao;
    }

    @Override
    public Result add(ForContact forContact) {
        this.forContactDao.save(forContact);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ForContact>> getAll() {
        return new SuccessDataResult<>(this.forContactDao.findAll());
    }

    @Override
    public DataResult<List<ForContact>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.forContactDao.getAllByCandidateId(candidateId));
    }
}
