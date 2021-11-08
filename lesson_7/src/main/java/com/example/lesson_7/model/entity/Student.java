package com.example.lesson_7.model.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Студент
 */
@Data
@Entity
@Table(name = "student")
public class Student {

    /**
     * Уникальный идентификатор студента
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Имя студента
     */
    @Column(name = "name")
    private String name;

    /**
     * Возраст студента
     */
    @Column(name = "age")
    private int age;
}
