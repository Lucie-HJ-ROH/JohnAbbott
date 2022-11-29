package com.example.teacher.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {
  
  @Id
  @Size(min = 4, max = 4, message = "exactly 4 digits")
  private String id;
  
  @NotBlank
  private String name;
  
  @NotBlank
  @Email
  private String email;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;
  
  @NotBlank
  @Size(min = 10, max = 10, message = "exactly 10 digits")
  private String phone;
  
  @NotBlank
  private String password;
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public Date getBirthDate() {
    return birthDate;
  }
  
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
}
