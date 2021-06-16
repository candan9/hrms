package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.ForContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForContactDao extends JpaRepository<ForContact,Integer> {
    List<ForContact> getAllByCandidateId(int candidateId);
}
