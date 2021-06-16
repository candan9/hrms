package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
    Result add(Photo photo);
    Result add(Photo photo, MultipartFile file);
    DataResult<List<Photo>> getAll();
    DataResult<List<Photo>> getAllByCandidateId(int candidateId);
}
