package patterns.creational.singleton;

class ClassSingleton {

    private static ClassSingleton instance;
    private static final Object mutex = new Object();

    public static ClassSingleton getInstance() {
        synchronized (mutex) {
            if (instance == null) {
                instance = new ClassSingleton();
            }
        }
        return instance;
    }

    private ClassSingleton() {
        // Empty hides default constructor
    }
}