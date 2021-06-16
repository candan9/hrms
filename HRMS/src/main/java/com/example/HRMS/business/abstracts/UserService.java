package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.User;

import java.util.List;

public interface UserService {

    Result add(User user);
    DataResult<User> getByEmail(String email);
    DataResult<List<User>> getAll();

}
