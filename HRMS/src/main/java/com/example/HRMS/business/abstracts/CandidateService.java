package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.dtos.CandidateCvDto;

import java.util.List;

public interface CandidateService {

    Result add(Candidate candidates);
    DataResult<Candidate> getByIdentificationNumber(String identificationNumber);
    DataResult<Candidate> getById(int id);
    DataResult<List<Candidate>> getAll();
    DataResult<CandidateCvDto> getResumeByCandidateId(int candidateId);

}
