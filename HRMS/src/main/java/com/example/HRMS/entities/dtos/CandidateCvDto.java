package com.example.HRMS.entities.dtos;

import java.util.List;

import com.example.HRMS.entities.concretes.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvDto {
    private Candidate candidate;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Photo> photos;
    private List<ForLanguage> forLanguages;
    private List<ForContact> forContacts;
    private List<Talent> talents;
}