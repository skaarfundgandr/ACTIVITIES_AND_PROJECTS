class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();
        thread.start(); // ERROR
        System.out.println("DEMO1");
    }
}
