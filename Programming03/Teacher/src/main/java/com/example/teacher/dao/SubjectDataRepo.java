package com.example.teacher.dao;

import com.example.teacher.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDataRepo extends JpaRepository<Subject, String> {
}
