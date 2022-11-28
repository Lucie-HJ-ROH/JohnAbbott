package com.example.teacher.service;

import com.example.teacher.dao.BookDataRepo;
import com.example.teacher.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
  
  @Autowired
  BookDataRepo repo;
  
  public List<Book> listAll() {
    return repo.findAll();
  }
  
  public void save(Book book) {
    repo.save(book);
  }
  
  public Book get(String isbn) {
    return repo.findById(isbn).get();
  }
  
  public void delete(String isbn) {
    repo.deleteById(isbn);
  }
}
