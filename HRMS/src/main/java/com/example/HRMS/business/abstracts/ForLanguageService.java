package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.ForLanguage;

import java.util.List;

public interface ForLanguageService {
    Result add(ForLanguage forLanguage);
    DataResult<List<ForLanguage>> getAll();
    DataResult<List<ForLanguage>> getAllByCandidateId(int candidateId);
}
