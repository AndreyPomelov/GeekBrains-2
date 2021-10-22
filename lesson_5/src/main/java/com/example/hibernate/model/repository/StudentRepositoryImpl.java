package com.example.hibernate.model.repository;

import com.example.hibernate.model.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    @Override
    public Student findById(int id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list;
        list = entityManager.createQuery("select a from Student a", Student.class).getResultList();
        return list;
    }

    @Override
    public void deleteById(int id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        entityManager.getTransaction().begin();
        Student persistStudent = entityManager.find(Student.class, student.getId());
        persistStudent.setName(student.getName());
        persistStudent.setMark(student.getMark());
        entityManager.persist(persistStudent);
        entityManager.getTransaction().commit();
    }
}
