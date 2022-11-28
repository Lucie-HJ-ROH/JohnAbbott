package com.example.teacher.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
  
  @Id
  @Size(min = 13, max = 13, message = "exactly 13 digits")
  private String isbn;
  
  @NotBlank
  private String title;
  
  @Max(value = 300, message = "up to 300 CAD")
  public Long price;
  
  @NotBlank
  private String author;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date publishDate;
  
  public String getIsbn() {
    return isbn;
  }
  
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public Long getPrice() {
    return price;
  }
  
  public void setPrice(Long price) {
    this.price = price;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public void setAuthor(String author) {
    this.author = author;
  }
  
  public Date getPublishDate() {
    return publishDate;
  }
  
  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }
}
