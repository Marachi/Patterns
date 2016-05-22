package state;

/**
 * Created by Славик on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i =0; i<10; i++){
            radio.play();
            radio.playNext();
        }
    }
}
interface Station{
    void play();
}
class Radio7 implements Station{

    @Override
    public void play() {
        System.out.println("Radio7...");
    }
}
class RadioDFM implements Station{

    @Override
    public void play() {
        System.out.println("RadioDFM...");
    }
}
class VestiFM implements Station{

    @Override
    public void play() {
        System.out.println("VestiFM...");
    }
}
class Radio{
    private Station station;
    void play(){
        station.play();
    }
    void playNext(){
        if (station instanceof Radio7){
            setStation(new RadioDFM());
        }else if (station instanceof  RadioDFM){
            setStation(new VestiFM());
        }else if (station instanceof  VestiFM) {
            setStation(new Radio7());
        }

    }
    public void setStation(Station station) {
        this.station = station;
    }
}

