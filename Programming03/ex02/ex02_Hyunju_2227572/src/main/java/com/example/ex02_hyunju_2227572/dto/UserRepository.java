package com.example.ex02_hyunju_2227572.dto;


import com.example.ex02_hyunju_2227572.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String username);
}
