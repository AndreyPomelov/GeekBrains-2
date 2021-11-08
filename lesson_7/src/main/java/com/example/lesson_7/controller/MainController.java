package com.example.lesson_7.controller;

import com.example.lesson_7.model.entity.Student;
import com.example.lesson_7.model.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Контроллер
 */
@Controller
@RequiredArgsConstructor
public class MainController {

    /**
     * Репозиторий для работы с базой данных
     */
    private final StudentRepository studentRepository;

    /**
     * Отобразить список всех студентов
     *
     * @param model Модель для передачи объекта в представление
     * @return Имя шаблона страницы
     */
    @GetMapping(value = "/students")
    public String students(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    /**
     * Добавить нового студента в базу данных
     * (открыть страницу для заполнения данных)
     *
     * @param model Модель для передачи объекта в представление
     * @return Имя шаблона страницы
     */
    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    /**
     * Сохранить нового студента в базу данных
     *
     * @param student Экземпляр студента для сохранения в БД
     * @return Имя шаблона страницы
     */
    @PostMapping(value = "/add")
    public String add(Student student) {
        studentRepository.save(student);
        return "added";
    }

    /**
     * Обновить данные студента в базе данных
     * (открыть страницу для редактирования данных)
     *
     * @param id Идентификатор студента
     * @param model Модель для передачи объекта в представление
     * @return Имя шаблона страницы
     */
    @GetMapping(value = "update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("student", studentRepository.findById(id));
        return "update";
    }

    /**
     * Сохранить изменения в данных студента в базу данных
     *
     * @param student Экземпляр студента с изменёнными данными
     * @return Имя шаблона страницы
     */
    @PostMapping(value = "/save")
    public String update(Student student) {
        studentRepository.save(student);
        return "updated";
    }

    /**
     * Удаление студента из базы данных
     *
     * @param id Идентификатор студента
     * @return Имя шаблона страницы
     */
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable int id) {
        studentRepository.delete(studentRepository.getById(id));
        return "deleted";
    }
}
