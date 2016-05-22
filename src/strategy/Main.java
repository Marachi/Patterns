package strategy;

/**
 * Created by Potyachuck Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,7};
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(a);
        strategyClient.setStrategy(new MergeSort());
        strategyClient.executeStrategy(a);
        strategyClient.setStrategy(new SelectionSort());
        strategyClient.executeStrategy(a);

    }
}
interface Sorting{
    void sort(int [] a);
}
class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void  executeStrategy(int [] arr){
        strategy.sort(arr);
    }
}
class BubbleSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("BubbleSort");
    }
}
class SelectionSort implements Sorting{
    public void sort(int[] arr) {
        System.out.println("SelectionSort");
    }
}
class MergeSort implements Sorting{
    public void sort(int[] arr){
    System.out.println("MergeSort");
    }
}