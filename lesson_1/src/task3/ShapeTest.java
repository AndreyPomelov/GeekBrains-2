package task3;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        shapes.add(new Triangle());

        shapes.forEach(Shape::draw);
    }
}
