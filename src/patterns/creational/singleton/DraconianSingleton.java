package patterns.creational.singleton;

public class DraconianSingleton {

    private static DraconianSingleton instance;


    public static synchronized DraconianSingleton getInstance() {
        if (instance == null) {
            instance = new DraconianSingleton();
        }
        return instance;
    }

    private DraconianSingleton() {
        // Hiding default constructor
    }

}
