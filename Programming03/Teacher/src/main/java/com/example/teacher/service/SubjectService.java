package com.example.teacher.service;

import com.example.teacher.dao.SubjectDataRepo;
import com.example.teacher.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectService {
  
  @Autowired
  SubjectDataRepo repo;
  
  public List<Subject> listAll() {
    return repo.findAll();
  }
  
  public void save(Subject subject) {
    repo.save(subject);
  }
  
  public Subject get(String code) {
    return repo.findById(code).get();
  }
  
  public void delete(String code) {
    repo.deleteById(code);
  }
}
