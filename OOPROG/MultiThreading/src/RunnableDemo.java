class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable demo");
    }
}

public class RunnableDemo {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Thread thread = new Thread(task);

        thread.start();
        Thread thread2 = new Thread(task);
        thread2.start();
    }
}
