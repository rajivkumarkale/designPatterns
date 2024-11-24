package singleton;

import java.io.Serializable;

/*
    Lazy Initialization means the object will be created when it is requested.

    The following implementation is not thread safe,
        as in a multithreaded code, the LazySingleton's multiple object could be created.
 */
public class LazySingleton implements Serializable {
    private static LazySingleton instance = null;
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
