package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Education;


import java.util.List;

public interface EducationService {
    Result add(Education candidateEducation);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
