package com.example.HRMS.dataAccess.abstracts;

import com.example.HRMS.entities.concretes.JobAdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvDao extends JpaRepository<JobAdv,Integer> {
    List<JobAdv> getAllByApplicationDeadlineLessThanEqual(LocalDate date);
    List<JobAdv> getAllByEmployer(int employerId);
    @Query("From JobAdv jp " +
            "inner join jp.jobAdvStatuses jps " +
            "left join jps.status status " +
            "where jps.id in " +
            "(select MAX(jps.id) from JobAdv jp join jp.jobAdvStatuses jps group by jp.id) " +
            "and status.id = :statusId")
    List<JobAdv> getAllByStatusName(int statusId);
}
