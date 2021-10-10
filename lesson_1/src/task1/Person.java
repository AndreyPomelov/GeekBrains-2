package task1;

import lombok.Data;

/**
 * Класс, описывающий человека,
 * конкретную личность
 */
@Data
public class Person {

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Второе имя (отчество)
     */
    private String middleName;

    /**
     * Страна проживания
     */
    private String country;

    /**
     * Адрес проживания
     */
    private String address;

    /**
     * Номер телефона
     */
    private String phone;

    /**
     * Возраст
     */
    private int age;

    /**
     * Пол
     */
    private GenderType gender;
}
