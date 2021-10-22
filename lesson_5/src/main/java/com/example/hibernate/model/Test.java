package com.example.hibernate.model;

import com.example.hibernate.model.entity.Student;
import com.example.hibernate.model.repository.StudentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Test {

    private final StudentRepositoryImpl repository;

    @PostConstruct
    public void test() {

        for (int i = 1; i <= 1000; i++) {
            Student student = new Student();
            student.setName("Name " + i);
            student.setMark("Mark " + i);
            repository.save(student);
        }

        System.out.println(repository.findById(777).getName());

        System.out.println(repository.findAll());

        repository.deleteById(999);

        Student student = new Student();
        student.setId(1000);
        student.setMark("Updated");
        student.setName("Updated");
        repository.update(student);
    }
}
