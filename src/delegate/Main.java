package delegate;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Triangle());
        painter.draw();
        painter.setGraphics(new Square());
        painter.draw();
        painter.setGraphics(new Circle());
        painter.draw();

    }
}
class A{
    void f(){
        System.out.println("f()");
    }
}
class B{
    A a = new A();
    void f(){
        a.f();
    }
}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    @Override
    public void draw() {
        System.out.println("Triangle if drawed");
    }
}
class Square implements Graphics{
    @Override
    public void draw() {
        System.out.println("Square is drawing");
    }
}
class Circle implements Graphics{
    @Override
    public void draw() {
        System.out.println("Circle is drawing");
    }
}
class Painter{
    Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
    void draw(){
        graphics.draw();
    }

}