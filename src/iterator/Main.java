package iterator;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator it = c.getIterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }

    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}
interface Aggregate{
    Iterator getIterator();
}
class Tasks implements Aggregate{
    String[] tasks = {"Build a house", "To grow a son", "To set a tree"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator{
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }
        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}