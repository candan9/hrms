package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Talent;

import java.util.List;

public interface TalentService {
    Result add(Talent candidateSkill);
    DataResult<List<Talent>> getAll();
    DataResult<List<Talent>> getAllByCandidateId(int candidateId);
}
