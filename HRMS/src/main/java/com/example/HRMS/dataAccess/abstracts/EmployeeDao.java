package com.example.HRMS.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Employee;
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
