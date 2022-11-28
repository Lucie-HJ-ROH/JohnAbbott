package com.example.ex02_hyunju_2227572.service;

import com.example.ex02_hyunju_2227572.dto.UserRepository;
import com.example.ex02_hyunju_2227572.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repo;

    public void save(User user) {
        repo.save(user);
    }


    public List<User> listAll() {
        return repo.findAll();
    }


    public User get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
