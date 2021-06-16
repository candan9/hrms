package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.JobAdvService;
import com.example.HRMS.core.results.DataResult;
import com.example.HRMS.core.results.Result;
import com.example.HRMS.entities.concretes.JobAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvs")
public class JobAdvsController {
	private enum Status{
        WAITING(1),APPROVED(2), REJECTED (3);
        private final Integer value;

        Status(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
    private JobAdvService jobAdvService;

    @Autowired
    public JobAdvsController(JobAdvService jobAdvService) {
        this.jobAdvService = jobAdvService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdv jobAdv){
        return this.jobAdvService.add(jobAdv);
    }

    @PostMapping("/toggleactivestatus")
    public Result toggleActiveStatus(@RequestParam int id){
        return this.jobAdvService.toggleActiveStatus(id);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdv>> getAll(){
        return this.jobAdvService.getAll();
    }

    @GetMapping("/getallbyapplicationdeadline")
    public DataResult<List<JobAdv>> getAllByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return this.jobAdvService.getAllByApplicationDeadline(date);
    }

    @GetMapping("/getallbyemployerid")
    public DataResult<List<JobAdv>> getAllByEmployer(@RequestParam int employerId){
        return this.jobAdvService.getAllByEmployerId(employerId);
    }
    
    @GetMapping("/getallapprovedstatus")
    public ResponseEntity<?> getAllApprovedStatus(){
        return ResponseEntity.ok(this.jobAdvService.getAllByStatusId(Status.APPROVED.getValue()));
    }

}
