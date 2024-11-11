class RaceCondition implements Runnable {
    private int count = 0;

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public void decrement() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        this.increment();
        System.out.println("Count for thread " + Thread.currentThread().getName() + " after increment: " + this.getCount());
        this.decrement();
        System.out.println("Count for thread " + Thread.currentThread().getName() + " after decrement: " + this.getCount());
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
