package builder;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Director {
    CarBuilder carBuilder;
    Car buildCar(){
        carBuilder.createCar();
        carBuilder.buildMake();
        carBuilder.buildMaxSpeed();
        carBuilder.buildTransmission();

        Car car = carBuilder.getCar();
        return car;
    }
    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }
}
