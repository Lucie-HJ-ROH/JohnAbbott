package com.example.crud.service;

import com.example.crud.dto.UserRepository;
import com.example.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService {
  
  @Autowired
  private UserRepository repo;
  
  public List<User> listAll() {
    return repo.findAll();
  }
  
  public void save(User user) {
    repo.save(user);
  }
  
  public User get(int id) {
    return repo.findById(id);
  }
  
  public void delete(int id) {
    repo.deleteById(id);
  }
}
