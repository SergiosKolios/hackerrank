package patterns.creational.singleton;

public class DclSingleton {

    private static volatile DclSingleton instance;

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton .class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    private DclSingleton() {
        // Hiding default constructor
    }
}
