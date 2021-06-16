package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Province;

public interface ProvinceService {
	  Result add(Province province);
	  DataResult<List<Province>> getAll();
}
