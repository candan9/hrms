package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Employment;

public interface EmploymentDao extends JpaRepository <Employment,Integer>{
 
}
