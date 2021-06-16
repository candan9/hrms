package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
