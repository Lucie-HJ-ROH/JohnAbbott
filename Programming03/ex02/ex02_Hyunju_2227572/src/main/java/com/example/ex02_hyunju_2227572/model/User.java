package com.example.ex02_hyunju_2227572.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "ex02_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String rePassword;

    @Column(nullable = false,  length = 45)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 45)
    private String email;


    @Column(nullable = false, unique = true, length = 45)
    private String gender;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthdate;

    @Column(nullable = false,  length = 45)
    private String address;

//    @Column(nullable = false, length = 10)
//    @NotBlank(message = "Please fill out the field")
//    private String bloodGroup;

    @Column(nullable = false, length = 10)
    @NotBlank(message = "Please fill out the field")
    private String department;


    @Column(nullable = false, unique = true, length = 45)
    private String course;

}
