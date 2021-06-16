package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.ForContact;

import java.util.List;

public interface ForContactService {
    Result add(ForContact candidateLink);
    DataResult<List<ForContact>> getAll();
    DataResult<List<ForContact>> getAllByCandidateId(int candidateId);
}
