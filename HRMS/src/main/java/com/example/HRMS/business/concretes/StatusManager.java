package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.StatusService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.StatusDao;
import com.example.HRMS.entities.concretes.Status;

@Service
public class StatusManager implements StatusService {
	private StatusDao statusDao;

    @Autowired
    public StatusManager(StatusDao statusDao) {
        this.statusDao = statusDao;
    }


    @Override
    public Result add(Status status) {
        this.statusDao.save(status);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Status>> getAll() {
        return new SuccessDataResult<>(this.statusDao.findAll());
    }

    @Override
    public DataResult<Status> getByName(String name) {
        return new SuccessDataResult<>(this.statusDao.getByName(name));
    }
}
