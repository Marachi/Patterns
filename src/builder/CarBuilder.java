package builder;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public abstract class CarBuilder {
    Car car;
    void createCar(){
        car= new Car();
    }

    abstract  void buildMake();
    abstract  void buildTransmission();
    abstract  void buildMaxSpeed();

    public Car getCar() {
        return car;
    }
}
