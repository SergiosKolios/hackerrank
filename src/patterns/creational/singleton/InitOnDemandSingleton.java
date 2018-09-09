package patterns.creational.singleton;

public class InitOnDemandSingleton {

    public static InitOnDemandSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private InitOnDemandSingleton() {
        // hide default constructor
    }

    private static class InstanceHolder {

        private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();

    }

    // Getters, Setters and What not
}
