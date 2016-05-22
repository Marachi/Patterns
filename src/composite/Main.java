package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Shape sq1 = new Square();
        Shape sq2 = new Square();
        Shape sq33 = new Square();
        Shape tr1 = new Triangle();
        Shape tr2 = new Triangle();
        Shape c1 = new Circle();
        Shape c2 = new Circle();
        Shape c3 = new Circle();
        Shape c4 = new Circle();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();
        composite1.addComponent(sq1);
        composite1.addComponent(sq2);
        composite2.addComponent(sq33);
        composite2.addComponent(tr1);
        composite2.addComponent(tr2);
        composite2.addComponent(c1);
        composite2.addComponent(c2);
        composite3.addComponent(c3);
        composite3.addComponent(c4);
        composite3.addComponent(composite1);
        composite3.addComponent(composite2);
        composite1.draw();
        System.out.println("==================================");
        composite2.draw();
        System.out.println("==================================");
        composite3.draw();

    }
}
interface Shape{
    void draw();
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi! I'm Square!");
    }
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi! I'm Triangle!");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Hi! I'm Circle!");
    }
}
class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    void addComponent (Shape shape){
        components.add(shape);
    }
    void removeComponent(Shape shape){
        components.remove(shape);
    }

    @Override
    public void draw() {
        components.forEach(Shape::draw);
    }
}