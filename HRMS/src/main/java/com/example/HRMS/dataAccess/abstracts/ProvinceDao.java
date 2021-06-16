package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceDao extends JpaRepository<Province,Integer> {
}
