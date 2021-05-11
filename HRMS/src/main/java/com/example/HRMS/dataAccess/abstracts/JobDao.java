package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job,Integer>{

}
