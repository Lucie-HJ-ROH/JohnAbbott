package com.example.teacher.service;

import com.example.teacher.dao.TeacherDataRepo;
import com.example.teacher.model.Teacher;
import com.example.teacher.model.TeacherDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService implements UserDetailsService {

  @Autowired
  TeacherDataRepo repo;
  
  public List<Teacher> listAll() {
    return repo.findAll();
  }
  public void save(Teacher teacher) {
    repo.save(teacher);
  }
  
  public Teacher get(String id) {
    return repo.findById(id).get();
  }
  
  public void delete(String id) {
    repo.deleteById(id);
  }
  
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    Teacher teacher = repo.findByStaffId(username);
  
    if (teacher == null) {
      throw new UsernameNotFoundException("Student not found");
    }
  
    return new TeacherDetail(teacher);
  }
}
