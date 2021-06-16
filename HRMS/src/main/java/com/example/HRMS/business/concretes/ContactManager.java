package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.ContactService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.ContactDao;
import com.example.HRMS.entities.concretes.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactManager implements ContactService {

    private ContactDao contactDao;

    public ContactManager(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Result add(Contact linkType) {
        this.contactDao.save(linkType);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Contact>> getAll() {
        return new SuccessDataResult<>(this.contactDao.findAll());
    }
}
