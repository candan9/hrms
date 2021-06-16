package com.example.HRMS.core.helpers;

import org.springframework.web.multipart.MultipartFile;

import com.example.HRMS.core.results.DataResult;

public interface ImageService {
    DataResult<?> save(MultipartFile file);
}
