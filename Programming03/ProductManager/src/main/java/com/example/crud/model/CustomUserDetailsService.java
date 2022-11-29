package com.example.crud.model;

import com.example.crud.dto.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    User user = userRepo.findUserBy(Integer.parseInt(username))
      System.out.println("find user " + user);
    
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    
    return new CustomUserDetails(user);
  }
}
