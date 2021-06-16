package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.ProvinceService;
import com.example.HRMS.core.results.*;
import com.example.HRMS.dataAccess.abstracts.ProvinceDao;
import com.example.HRMS.entities.concretes.Province;

@Service
public class ProvinceManager implements ProvinceService {
	 private ProvinceDao provinceDao;

	    @Autowired
	    public ProvinceManager(ProvinceDao provinceDao) {
	        this.provinceDao = provinceDao;
	    }


	    @Override
	    public Result add(Province province) {
	        this.provinceDao.save(province);
	        return new SuccessResult();
	    }

	    @Override
	    public DataResult<List<Province>> getAll() {
	        return new SuccessDataResult<>(this.provinceDao.findAll());
	    }
}
