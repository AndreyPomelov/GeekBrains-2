package com.example.lesson_7.model.repository;

import com.example.lesson_7.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий студентов для работы с базой данных
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
