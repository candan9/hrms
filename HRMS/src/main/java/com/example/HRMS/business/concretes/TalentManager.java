package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.TalentService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.TalentDao;
import com.example.HRMS.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentManager implements TalentService {

    private TalentDao talentDao;

    @Autowired
    public TalentManager(TalentDao talentDao) {
        this.talentDao = talentDao;
    }

    @Override
    public Result add(Talent talent) {
        this.talentDao.save(talent);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Talent>> getAll() {
        return new SuccessDataResult<>(this.talentDao.findAll());
    }

    @Override
    public DataResult<List<Talent>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.talentDao.getAllByCandidateId(candidateId));
    }
}
