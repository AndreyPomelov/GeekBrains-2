package task1;

/**
 * Создатель человека (личности)
 */
public class PersonBuilder {

    /**
     * Создаваемый экземпляр личности
     */
    private final Person person;

    /**
     * Конструктор
     */
    public PersonBuilder() {
        person = new Person();
    }

    /**
     * Установка имени
     *
     * @param firstName Имя
     * @return Экземпляр билдера
     */
    public PersonBuilder firstName(String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    /**
     * Установка фамилии
     *
     * @param lastName Фамилия
     * @return Экземпляр билдера
     */
    public PersonBuilder lastName(String lastName) {
        person.setLastName(lastName);
        return this;
    }

    /**
     * Установка второго имени (отчества)
     *
     * @param middleName Второе имя (отчество)
     * @return Экземпляр билдера
     */
    public PersonBuilder middleName(String middleName) {
        person.setMiddleName(middleName);
        return this;
    }

    /**
     * Установка страны проживания
     *
     * @param country Страна
     * @return Экземпляр билдера
     */
    public PersonBuilder country(String country) {
        person.setCountry(country);
        return this;
    }

    /**
     * Установка адреса проживания
     *
     * @param address Адрес
     * @return Экземпляр билдера
     */
    public PersonBuilder address(String address) {
        person.setAddress(address);
        return this;
    }

    /**
     * Установка номера телефона
     *
     * @param phone Номер телефона
     * @return Экземпляр билдера
     */
    public PersonBuilder phone(String phone) {
        person.setPhone(phone);
        return this;
    }

    /**
     * Установка возраста
     *
     * @param age Возраст
     * @return Экземпляр билдера
     */
    public PersonBuilder age(int age) {
        person.setAge(age);
        return this;
    }

    /**
     * Установка пола
     *
     * @param gender Пол
     * @return Экземпляр билдера
     */
    public PersonBuilder gender(GenderType gender) {
        person.setGender(gender);
        return this;
    }

    /**
     * Создание готового экземпляра личности
     *
     * @return Экземпляр личности
     */
    public Person build() {
        return person;
    }
}
