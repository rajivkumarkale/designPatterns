package singleton;

/*
    -> This is eager initialization concept where
      as soon as JVM start the object will be created irrespective whether it got accessed by
      any code in application or not.

    -> Use eager initialization when the singleton instance is lightweight and guaranteed to be used.

    -> This implementation is thread safe. JVM makes sure of that.
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
