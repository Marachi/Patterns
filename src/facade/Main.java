package facade;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.copy();
    }
}
class Power{
    void on(){
        System.out.println("on");
    }
    void off(){
        System.out.println("off");
    }
}
class DVDRom{
    private boolean data = false;
    boolean hasdata(){
        return  data;
    }
    void  loadData(){
        data=true;
    }
    void unload(){
        data=false;
    }
}
class HDD{
    void coptFromDVD(DVDRom dvdRom){
        if(dvdRom.hasdata()){
            System.out.println("COPY");
        }else {
            System.out.println("ERROR. INPUT DATA FIRST");
        }
    }
}
class Computer{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd =new HDD();
    void copy(){
        power.on();
        dvdRom.loadData();
        hdd.coptFromDVD(dvdRom);
    }
}
