package com.example.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCandidateDto {

    private String firstName;
    private String lastName;
    private String identificationNumber;
    private String birthYear;
    private String email;
    private String password;
    private String passwordConfirm;

}