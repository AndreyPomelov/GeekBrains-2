package task2;

abstract class Car {

    /* Здесь была ошибка - не был реализован класс Engine,
    отсюда - ошибка компиляции
     */
    public Engine engine;
    private String color;
    private String name;


    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    /*
    Геттеры и сеттеры можно заменить аннотацией ломбока
    @Data, существенно сократив код
     */
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
