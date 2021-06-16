package com.example.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_adv_statuses")
public class JobAdvStatus {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "created_at")
	    private LocalDate createdAt;

	    @ManyToOne()
	    @JoinColumn(name = "job_adv_id")
	    private JobAdv jobAdv;

	    @ManyToOne()
	    @JoinColumn(name = "by_employee_id")
	    private Employee employee;

	    @ManyToOne()
	    @JoinColumn(name = "status_id")
	    private Status status;
}
