package patterns.creational.singleton;

public enum EnumSingleton {

    INSTANCE;

    private String info;

    private EnumSingleton() {
        this.info = info;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    // Getters, Setters and whatnot;
}

