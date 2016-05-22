package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Potayhuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObsrver(new ConsoleObserver());
        station.addObsrver(new FileObserver());
        station.setMeasurements(12,1200);
        station.setMeasurements(-4,1788);

    }
}

interface Observed {
    void addObsrver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
interface  Observer{
    void handleEvent(int temp, int present);
}
class MeteoStation implements Observed {
    private int temperature;
    private int pressure;
    private List<Observer> list = new ArrayList<>();
    void setMeasurements(int t, int p){
        temperature=t;
        pressure=p;
        notifyObserver();
    }
    @Override
    public void addObsrver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o:list) {
            o.handleEvent(temperature, pressure);
        }
    }
}
class ConsoleObserver implements Observer{

    @Override
    public void handleEvent(int temp, int preassure) {
        System.out.println("temp: "+ temp +", preassure: "+preassure);
    }
}
class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int pressure) {
        File f;
        try{
            f = File.createTempFile("TempPressure","_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Weather is changed. Temperature = "+temp +", Pressure = "+pressure+".");
            pw.println();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}