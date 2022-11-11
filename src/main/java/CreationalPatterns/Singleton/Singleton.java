package main.java.CreationalPatterns.Singleton;

public class Singleton {
    private static Singleton instance;
    public String value;

    // The constructor is private so that this class cannot be
    //instantiated (more than one time)
    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
}
