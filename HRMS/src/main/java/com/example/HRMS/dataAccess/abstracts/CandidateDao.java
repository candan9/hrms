package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    Candidate getByIdentificationNumber(String identificationNumber);
}
