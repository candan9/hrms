package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Contact;

import java.util.List;

public interface ContactService {
    Result add(Contact linkType);
    DataResult<List<Contact>> getAll();
}
