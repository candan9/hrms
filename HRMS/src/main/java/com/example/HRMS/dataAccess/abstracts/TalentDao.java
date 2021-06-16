package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Talent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentDao extends JpaRepository<Talent,Integer> {
    List<Talent> getAllByCandidateId(int candidateId);
}
