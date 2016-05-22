package builder;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class SubaruBuilder  extends CarBuilder{
    @Override
    void buildMake() {
        car.setName("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }
}
