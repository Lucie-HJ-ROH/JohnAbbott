package com.example.teacher.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "subjects")
public class Subject {
  
  @Id
  @Size(min = 6, max =6, message = "The subject code (exactly 6 chars)")
  private String subjectCode;
  
  @NotBlank
  private String subjectName;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  
  @Min(value = 0, message = "number of credits should be positive integer between 0 to 4")
  @Max(value = 4, message = "number of credits should be positive integer between 0 to 4")
  private int credit;
  
  public String getSubjectCode() {
    return subjectCode;
  }
  
  public void setSubjectCode(String subjectCode) {
    this.subjectCode = subjectCode;
  }
  
  public String getSubjectName() {
    return subjectName;
  }
  
  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }
  
  public Date getStartDate() {
    return startDate;
  }
  
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  public int getCredit() {
    return credit;
  }
  
  public void setCredit(int credit) {
    this.credit = credit;
  }
}
