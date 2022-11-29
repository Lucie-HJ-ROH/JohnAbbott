package com.example.ex.dao;


import com.example.ex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepo extends JpaRepository<User, Integer> {
}
