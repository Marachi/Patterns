package prototype;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Vasia", 18);
        System.out.println(human);
    }
}
interface Copyable{
    Object copy();
}
class Human implements Copyable{
    int age;
    String name;


    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(name, age );
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}