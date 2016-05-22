package mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        TexetChat chat = new TexetChat();
        User admin = new Admin(chat);
        User u1 = new SimpleUser(chat);
        User u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUsers(u1);
        chat.addUsers(u2);

        u1.sentMsg("Hi, I'm u1!");
        u2.sentMsg("Hi, I'm u2!");
    }
}
interface User{
    void sentMsg(String msg);
    void getMsg(String msg);

}
interface Chat{
    void sentMsg(String msg, User user);
}
class Admin implements User{
    private Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sentMsg(String msg) {
        chat.sentMsg(msg,this);
    }
    @Override
    public void getMsg(String msg) {
        System.out.println("Admin get a msg: "+msg);
    }
}
class SimpleUser implements User{
    private Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sentMsg(String msg) {
        chat.sentMsg(msg,this);
    }
    @Override
    public void getMsg(String msg) {
        System.out.println("Simple user get a msg: "+msg);
    }
}
class TexetChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    @Override
    public void sentMsg(String msg, User user) {
        for(User u:users){
            u.getMsg(msg);
        }
        admin.getMsg(msg);
    }
}