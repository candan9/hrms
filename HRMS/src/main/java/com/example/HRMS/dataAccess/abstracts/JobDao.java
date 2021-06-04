package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job,Integer> {
    Job getByName(String name);
}
