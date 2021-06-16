package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.PhotoService;
import com.example.HRMS.core.helpers.ImageService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.core.results.SuccessDataResult;
import com.example.HRMS.core.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.PhotoDao;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    private PhotoDao photoDao;
    private ImageService imageService;

    @Autowired
    public PhotoManager(PhotoDao photoDao,ImageService imageService) {
        this.photoDao = photoDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(Photo photo) {
        this.photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public Result add(Photo photo, MultipartFile file) {
        Map<String,String> result = (Map<String,String>)imageService.save(file).getData();
        String url = result.get("url");
        photo.setUrl(url);
        photo.setUploadedAt(LocalDate.now());
        return add(photo);
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<>(this.photoDao.findAll());
    }

    @Override
    public DataResult<List<Photo>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.photoDao.getAllByCandidateId(candidateId));
    }
}
