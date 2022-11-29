package com.example.teacher.dao;

import com.example.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDataRepo extends JpaRepository<Teacher, String> {
  
  @Query("SELECT u FROM Teacher u WHERE u.id = ?1")
  public Teacher findByStaffId(String id);

}
