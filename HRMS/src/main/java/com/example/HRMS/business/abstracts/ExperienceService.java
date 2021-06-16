package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    Result add(Experience candidateExperience);
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}
