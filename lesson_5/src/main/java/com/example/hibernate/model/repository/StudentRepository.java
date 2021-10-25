package com.example.hibernate.model.repository;

import com.example.hibernate.model.entity.Student;
import java.util.List;

public interface StudentRepository {

    Student findById(int id);

    List<Student> findAll();

    void deleteById(int id);

    void save(Student student);

    void update(Student student);
}
