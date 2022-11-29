package com.example.ex.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String passwordErrorMessage;

    @NotBlank(message = "Please fill out the field")
    @Email(message = "Please enter a valid email address")
    private String email;


//    #Password Encryption

    @Column(name="password", length =500)
    private String password;

    @Transient // db does not save
    @NotBlank(message = "Please fill out the field")
    @Size(min = 10, max = 20, message = "Please enter between 10 to 20")
    private String plainPassword;

    @Transient // db does not save
    @NotBlank(message = "Please fill out the field")
    private String repassword;


    @NotBlank(message = "Please fill out the field")
    @Size(min = 5, max = 15, message = "Minimum  - 5 , Maximum - 15")
    private String firstname;

    @NotBlank(message = "Please fill out the field")
    @Size(min = 5, max = 15, message = "Minimum  - 5 , Maximum - 15")
    private String lastname;

    @NotBlank(message = "Please fill out the field")
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
//    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$")
    private String phonenumber;

    @NotBlank(message = "Please fill out the field")
    @Size(min = 5, max = 30, message = "Maximum length of the field is 30")
    private String address;

    @NotBlank(message = "Please fill out the field")
    @Size(min = 5, max = 30, message = "Maximum length of the field is 30")
    private String town;

    @NotBlank(message = "Please fill out the field")
    @Size(min = 2, max = 30, message = "Maximum length of the field is 30")
    private String region;

    @NotBlank(message = "Please fill out the field")
    @Pattern(regexp="^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$", message ="Invalid postcode format")
    @Size(min = 6, max = 6 , message = "Postcode must be 6 ")
    private String zip;

    @NotBlank(message = "Please fill out the field")
    @Size(min = 2, max = 30, message = "Maximum length of the field is 30")
    private String country;


//    #Password Encryption
    public void setPlainPassword(String plainPassword) {
        //System.out.println("PASSWORD BEFORE " + plainPassword);
        this.password = new BCryptPasswordEncoder().encode(plainPassword);
        //System.out.println("HERE IS PASSWORD" + this.password + "PASSWORD LENGTH = " + (this.password).length());
        this.plainPassword = plainPassword;
    }


    @AssertTrue(message = "Password is not matched")
    public boolean isPasswordMatch(){
        if(!plainPassword.equals(repassword)){
            passwordErrorMessage = "Password is not matched";
            return false;
        }
        return true;

    }

}
