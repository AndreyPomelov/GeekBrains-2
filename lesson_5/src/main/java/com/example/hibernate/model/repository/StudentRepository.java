package com.example.hibernate.model.repository;

import com.example.hibernate.model.entity.Student;

import java.util.List;

public interface StudentRepository {

    public Student findById(int id);

    public List<Student> findAll();

    public void deleteById(int id);

    public void save(Student student);

    public void update(Student student);
}
