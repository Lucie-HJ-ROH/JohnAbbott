package com.example.crud.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;



@Entity
@Data
@Table(name = "staff")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Please fill out the ID")
    @Min(value = 1000, message = "ID must be 4 digits")
    @Max(value = 9999, message = "ID must be 4 digits")
    private int userId;

    @NotBlank(message = "Please fill out the name")
    @Size(min = 5, max = 15 , message = "min = 5, max = 15")
    private String name;


    @NotBlank(message = "Pleasefill out the email")
    @Email(message = "Please enter a valid email address")
    private String email;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @Column(name="password", length =500)
    private String password;

//    @Transient
    @NotBlank(message = "Please fill out the password")
    @Size(min = 8, max = 20, message = "min = 8, max = 20")
    private String plainpassword;

    @NotBlank(message = "Please fill out the field")
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    private String phoneNumber;







    //    #Password Encryption
    public void setPlainpassword(String plainpassword) {
        //System.out.println("PASSWORD BEFORE " + plainPassword);
        this.password = new BCryptPasswordEncoder().encode(plainpassword);
        //System.out.println("HERE IS PASSWORD" + this.password + "PASSWORD LENGTH = " + (this.password).length());
        this.plainpassword = plainpassword;
    }
}
