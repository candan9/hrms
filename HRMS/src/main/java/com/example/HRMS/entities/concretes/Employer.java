package com.example.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvs"})
@Table(name="employers")
public class Employer extends User{

    @Column(name="company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name="web_address")
    @NotNull
    @NotBlank
    private String webAddress;

    @Column(name="phone_number")
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Column(name="is_activated_by_employee")
    private boolean isActivatedByEmployee;

    @OneToMany(mappedBy = "employer")
    private List<JobAdv> jobAdvs;
}