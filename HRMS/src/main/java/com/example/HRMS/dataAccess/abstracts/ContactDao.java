package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
}
