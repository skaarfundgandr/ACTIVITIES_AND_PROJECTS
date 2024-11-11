class RaceCondition implements Runnable {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
    // Race Condition. Leads to undefined behavior
    @Override
    public void run() {
        increment();
        System.out.println("Count for thread " +
                            Thread.currentThread().getName() +
                            " after increment: " + getCount());
        decrement();
        System.out.println("Count for thread " +
                            Thread.currentThread().getName() +
                            " after decrement: " + getCount());
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) {
        RaceCondition raceCondition = new RaceCondition();

        Thread task1 = new Thread(raceCondition, "Thread 1");
        Thread task2 = new Thread(raceCondition, "Thread 2");
        Thread task3 = new Thread(raceCondition, "Thread 3");

        task1.start();
        task2.start();
        task3.start();
    }
}
