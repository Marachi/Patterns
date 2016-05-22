package builder;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Director director = new Director();
        director.setCarBuilder(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}
