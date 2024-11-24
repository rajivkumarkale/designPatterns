package singleton;
import java.io.Serializable;

/*
    -> Let's say your singleton has implemented serialization.
         Now what will happen if you serialize object and deserialize.
         During deserialization, it will create the new object every time if we go in traditional way.

    -> To resolve it add readResolve method which will ensure that during deserialize we return same instance.
 */
public class SerializableSingleton implements Serializable {
    private static SerializableSingleton instance = null;
    private SerializableSingleton() {}

    public static SerializableSingleton getInstance() {
        if(instance == null) {
            synchronized (SerializableSingleton.class) {
                if(instance == null) {
                    instance = new SerializableSingleton();
                }
            }
        }

        return instance;
    }

    protected Object readResolve(){
        return instance;
    }
}
