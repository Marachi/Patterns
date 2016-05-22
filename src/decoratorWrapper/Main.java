package decoratorWrapper;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        PrintInterface p = new QuotesDecorator(
                                new LeftBracketDecorator(
                                 new RightBracketDecorator(
                                  new Printer("Hello!"))));
        p.print();
    }
}
interface PrintInterface{
    void print();
}
class Printer implements PrintInterface{

    private String value;

    Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
class QuotesDecorator  extends Decorator{
    QuotesDecorator(PrintInterface component){
        super(component);
    }
    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}
class LeftBracketDecorator  extends Decorator{
    LeftBracketDecorator(PrintInterface component){
        super(component);
    }
    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}
class RightBracketDecorator extends Decorator{
    RightBracketDecorator(PrintInterface component){
        super(component);
    }
    @Override
    public void print() {
        System.out.print("]");
    }
}
abstract  class  Decorator implements PrintInterface{
    PrintInterface component;
    Decorator(PrintInterface component) {
        this.component = component;
    }
}