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
@Table(name="candidates")
public class Candidate extends User{

    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "identification_number")
    @NotNull
    @NotBlank
    private String identificationNumber;

    @Column(name = "birth_year")
    @NotNull
    @NotBlank
    private String birthYear;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<Education> educations;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<ForLanguage> forLanguages;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<ForContact> forContacts;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<Talent> talents;

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore()
    private List<Photo> photos;
}