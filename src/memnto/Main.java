package memnto;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL_1",30);
        File file=new File();
        file.setSave(game.save());



    }
}
class  Game{
    private  String lvl;
    private int ms;
    void set(String lvl, int ms){
        this.lvl=lvl;
        this.ms=ms;
    }
    void load(Save save){
        this.ms=save.getMs();
        this.lvl=save.getLvl();
        }
    Save save(){
        return  new Save(lvl, ms);
    }
}
class Save{
    private  String lvl;
    private int ms;

    public Save(String lvl, int ms) {
        this.lvl = lvl;
        this.ms = ms;
    }

    public String getLvl() {
        return lvl;
    }

    public int getMs() {
        return ms;
    }
}
class File{
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}