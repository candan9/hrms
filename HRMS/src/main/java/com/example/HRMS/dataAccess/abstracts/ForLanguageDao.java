package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.ForLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForLanguageDao extends JpaRepository<ForLanguage,Integer> {
    List<ForLanguage> getAllByCandidateId(int candidateId);
}
