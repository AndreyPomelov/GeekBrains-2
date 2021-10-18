package task1;

/**
 * Класс для тестирования задания
 */
public class PersonTest {

    /**
     * Точка входа
     *
     * @param args Передаваемые аргументы
     */
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .firstName("Bender")
                .middleName("Bending")
                .lastName("Rodriguez")
                .country("USA")
                .address("New New-York")
                .phone("8-800-EXPRESS")
                .age(4)
                .gender(GenderType.Robot)
                .build();

        System.out.println(person.toString());
    }
}
