class ThreadStarvation implements Runnable {
    @Override
    public void run() {
        // Thread obtains a lock on the entire code block
        // Blocking other threads to execute until the thread that has
        // The lock is finished
        synchronized(this) {
            System.out.println("Thread created!");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadStarvationDemo {
    public static void main(String[] args) {
        ThreadStarvation tStarvation = new ThreadStarvation();

        Thread thread1 = new Thread(tStarvation);
        Thread thread2 = new Thread(tStarvation);

        thread1.start();
        thread2.start();
    }
}
