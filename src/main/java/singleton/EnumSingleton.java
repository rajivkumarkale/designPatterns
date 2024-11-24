package singleton;

/*
    Using an enum is the most robust way to prevent reflection and ensure thread safety.
    Java ensures that enum instances are inherently singleton,
        and serialization/deserialization of enums always returns the same instance.
 */
public enum EnumSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.println("do something cool");
    }
}
