package com.example.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name="employees")
public class Employee extends User{
	    @Column(name = "first_name")
	    @NotNull
	    @NotBlank
	    private String firstName;

	    @Column(name = "last_name")
	    @NotNull
	    @NotBlank
	    private String lastName;

	    @OneToMany(mappedBy = "employee")
	    @JsonIgnore()
	    private List<JobAdvStatus> jobAdvStatuses;
}
