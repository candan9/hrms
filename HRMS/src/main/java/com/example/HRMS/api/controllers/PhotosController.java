package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.PhotoService;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {

    private PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId) {
        Photo photo = new Photo();
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        photo.setCandidate(candidate);
        return ResponseEntity.ok(this.photoService.add(photo,file));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.photoService.getAll());
    }
}
