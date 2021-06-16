package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);
}
