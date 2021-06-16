package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    List<Experience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
