package visitor;

/**
 * Created by Potaychuck Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        CarElement car = new CarElement();
        car.accept(new MechanicVisitor());
        car.accept(new HooliganVisitor());
    }
}
interface Visitor{
    void visit(EngineElement element);
    void visit(BodyElement element);
    void visit(WheelElement element);
    void visit(CarElement element);
}
interface Element{
    void accept(Visitor visitor);
}
class BodyElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class EngineElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class HooliganVisitor implements Visitor{

    @Override
    public void visit(EngineElement element) {
        System.out.println("Engine turned on!");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Body is kicked!");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Wheel " + element.getName()+" is kicked!");
    }

    @Override
    public void visit(CarElement element) {
        System.out.println("Car is hijacked!");
    }
}
class MechanicVisitor implements Visitor{

    @Override
    public void visit(EngineElement element) {
        System.out.println("Engine is checked!");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Body is cleaned!");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Wheel " + element.getName()+" is cleaned!");
    }

    @Override
    public void visit(CarElement element) {
        System.out.println("Car is repaired!");
    }
}
class CarElement implements Element{
    private Element[] elements;

    CarElement() {
        this.elements = new Element[]{new WheelElement("Front left"),
                new WheelElement("End left"),
                new WheelElement("Front right"),
                new WheelElement("Front left"),
                new BodyElement(),
                new EngineElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element e:elements) {
            e.accept(visitor);
        }
    }
}
class WheelElement implements Element {
    String name;
    WheelElement(String s) {
        name=s;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
