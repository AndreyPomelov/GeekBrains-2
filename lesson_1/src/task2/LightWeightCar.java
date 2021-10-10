package task2;

/* Здесь логическая ошибка. Класс не реализует интерфейс
Stopable. Но ведь автомобиль должен уметь останавливаться.
Кроме того, поскольку все автомобили должны уметь двигаться
и останавливаться, можно было бы создать единый интерфейс,
унаследовав его от Moveable и Stopable. А классы
автомобилей наследовать уже от этого одного интерфейса.
 */
class LightWeightCar extends Car implements Moveable{

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
