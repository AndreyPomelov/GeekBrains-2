package task2;

/*
Здесь была ошибка. Т.к. Moveable и Stopable - это интерфейсы,
при их имплементации нужно указывать ключевое слово implements
Кроме того, при наследовании от класса Car необходимо либо
реализовать метод open(), либо данный класс тоже сделать абстрактным.
Кроме того, в случае если реализация метода open() будет повторяться
у всех автомобилей, имеет смысл перенести её реализацию в супер-класс,
чтобы не было повторения кода.
 */
class Lorry extends Car implements Moveable, Stopable {

    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
}