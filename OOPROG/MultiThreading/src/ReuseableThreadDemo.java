class ReuseableThread implements Runnable {
    private Thread t;
    @Override
    public void run() {
        System.out.println("Hello");
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }
}

public class ReuseableThreadDemo {
    public static void main(String[] args) {
        ReuseableThread rt = new ReuseableThread();

        rt.start();
        rt.start();
    }
}
