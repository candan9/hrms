package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Status;

public interface StatusService {
	Result add(Status status);
    DataResult<List<Status>> getAll();
    DataResult<Status> getByName(String name);
}
