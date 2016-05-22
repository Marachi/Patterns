package factory;

import java.util.Date;

/**
 * Created by Potaychuk Svbiatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Watch w = new DigitalWatchMAker().createWatch();
        System.out.println(w);
    }
}
interface  Watch{
    void showTime();
}
class DigitWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("XXXX_VVII");
    }
}
interface WatchMaker{
    Watch createWatch();
}
class DigitalWatchMAker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new DigitWatch();
    }
}
class RomeWatchMAker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}