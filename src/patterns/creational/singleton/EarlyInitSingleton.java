package patterns.creational.singleton;

public class EarlyInitSingleton {
    private static final EarlyInitSingleton instance = new EarlyInitSingleton();

    public EarlyInitSingleton getInstance() {
        return instance;
    }

    private EarlyInitSingleton() {
        // Hide default constructor and what not
    }
}