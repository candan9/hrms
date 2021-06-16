package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobAdvStatus;

public interface JobAdvStatusDao extends JpaRepository<JobAdvStatus,Integer>{
	  List<JobAdvStatus> getAllByJobAdvId(int jobAdvId);
	  JobAdvStatus getTopByJobAdvIdOrderByIdDesc(int jobAdvId);
}
