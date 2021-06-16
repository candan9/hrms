package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {
    List<Education> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
