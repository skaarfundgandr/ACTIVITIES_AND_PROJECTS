class Deadlock implements Runnable {
    String a, b;

    public Deadlock(String a, String b) {
        this.a = a;
        this.b = b;
    }
    // This method leads to a deadlock
    // When b is used by another thread
    private void printBothStrings() {
        synchronized(a) {
            System.out.println(a);
            synchronized(b) {
                System.out.println(b);
            }
        }
    }
    @Override
    public void run() {
        printBothStrings();
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        String first = "First string";
        String second = "Second string";

        Thread t1 = new Thread(new Deadlock(first, second));
        Thread t2 = new Thread(new Deadlock(second, first));

        t1.start();
        t2.start();
        // Both threads never completes execution
    }
}
