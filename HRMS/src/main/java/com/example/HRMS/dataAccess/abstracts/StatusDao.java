package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HRMS.entities.concretes.Status;

public interface StatusDao extends JpaRepository<Status,Integer> {
	Status getByName(String name);
}
