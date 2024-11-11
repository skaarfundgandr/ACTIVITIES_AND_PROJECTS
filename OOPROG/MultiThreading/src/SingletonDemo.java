class Singleton {
    private static volatile Singleton instance = null;
    String str;

    private Singleton() {
        str = "Singleton test";
    }

    public static Singleton Instance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton test = Singleton.Instance();
        Singleton test2 = Singleton.Instance();

        System.out.println(test.str);

        System.out.println(test.hashCode());
        System.out.println(test2.hashCode());
    }
}