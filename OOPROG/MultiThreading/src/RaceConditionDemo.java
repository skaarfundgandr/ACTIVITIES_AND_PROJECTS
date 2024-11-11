import java.util.ArrayList;

class RaceCondition implements Runnable {
    ArrayList<Integer> arrayList;

    public RaceCondition(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        Integer value;
        // This block leads to a race condition
        value = arrayList.get(2);
        value = value + 1;
        arrayList.set(2, value);
        value = arrayList.get(2);
        value = value - 2;
        arrayList.set(2, value);
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);

        System.out.println("Arraylist before multithreading:");
        System.out.println(arrList);

        RaceCondition raceCondition = new RaceCondition(arrList);

        Thread task1 = new Thread(raceCondition);
        Thread task2 = new Thread(raceCondition);
        Thread task3 = new Thread(raceCondition);

        task1.start();
        task2.start();
        task3.start();

        System.out.println("ArrayList during multithreading:");
        System.out.println(arrList);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ArrayList after multithreading:");
        System.out.println(arrList);
    }
}
