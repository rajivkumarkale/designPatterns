package singleton;

/*
    Double lock implementation of Singleton Pattern which works in multithreaded environment.

    Use lazy initialization when the singleton instance is heavy and may not always be needed.
 */
public class MultithreadedSingleton {
    private static MultithreadedSingleton instance = null;
    private MultithreadedSingleton() {}

    public static MultithreadedSingleton getInstance() {
        if(instance == null){
            synchronized (MultithreadedSingleton.class) {
                if(instance == null){
                    instance = new MultithreadedSingleton();
                }
            }
        }

        return instance;
    }
}
