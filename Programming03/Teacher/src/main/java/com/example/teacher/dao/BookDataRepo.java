package com.example.teacher.dao;

import com.example.teacher.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDataRepo extends JpaRepository<Book, String> {
  
}
