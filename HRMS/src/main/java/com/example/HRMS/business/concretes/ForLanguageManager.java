package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.ForLanguageService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.ForLanguageDao;
import com.example.HRMS.entities.concretes.ForLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForLanguageManager implements ForLanguageService {

    private ForLanguageDao forLanguageDao;

    @Autowired
    public ForLanguageManager(ForLanguageDao forLanguageDao) {
        this.forLanguageDao = forLanguageDao;
    }

    @Override
    public Result add(ForLanguage forLanguage) {
        this.forLanguageDao.save(forLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ForLanguage>> getAll() {
        return new SuccessDataResult<>(this.forLanguageDao.findAll());
    }

    @Override
    public DataResult<List<ForLanguage>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.forLanguageDao.getAllByCandidateId(candidateId));
    }
}
