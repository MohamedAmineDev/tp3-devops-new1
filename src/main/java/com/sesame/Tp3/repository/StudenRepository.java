package com.sesame.Tp3.repository;

import com.sesame.Tp3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudenRepository extends JpaRepository<Student, UUID> {
}
