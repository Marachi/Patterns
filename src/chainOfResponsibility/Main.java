package chainOfResponsibility;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMsg("All fine!", Level.INFO);
        logger0.writeMsg("Debuging!", Level.DEBUG);
        logger0.writeMsg("ERROR!", Level.ERROR);

    }
}
class Level{
     static final int ERROR = 1;
     static final int DEBUG = 2;
     static final int INFO = 3;
}
abstract class Logger{
    private int priority;
    private Logger next;

     Logger(int priority) {
        this.priority = priority;
    }

     void setNext(Logger next) {
        this.next = next;
    }
    void writeMsg(String msg, int level){
        if (level<=priority){
                write(msg);
        }
        if (next!=null){
            next.writeMsg(msg, level);
        }
    }
    abstract void write(String msg);
}
class SMSLogger extends Logger{
     SMSLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String msg) {
        System.out.println("SMSLogger: "+msg );
    }
}
class EmailLogger extends Logger{
     EmailLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String msg) {
        System.out.println("EmailLogger: "+msg );
    }
}
class FileLogger extends Logger{
     FileLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String msg) {
        System.out.println("FileLogger: "+msg );
    }
}