package com.example.relations.dao;

import com.example.relations.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StudentDAO extends JpaRepository<Student, Integer> {
}
