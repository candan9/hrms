package com.example.HRMS.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    @NotBlank
    private int id;

    @Column(name="email")
    @NotNull
    @NotBlank
    private String email;

    @Column(name="password")
    @NotNull
    @NotBlank
    private String password;

    @Column(name="is_verified_by_email")
    private boolean isVerifiedByEmail;
}