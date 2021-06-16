package com.example.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployerDto {

    private String companyName;
    private String website;
    private String phoneNumber;
    private String email;
    private String password;
    private String passwordConfirm;
}