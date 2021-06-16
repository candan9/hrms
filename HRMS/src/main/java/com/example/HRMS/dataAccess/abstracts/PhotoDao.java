package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoDao extends JpaRepository<Photo,Integer> {
    List<Photo> getAllByCandidateId(int candidateId);
}
